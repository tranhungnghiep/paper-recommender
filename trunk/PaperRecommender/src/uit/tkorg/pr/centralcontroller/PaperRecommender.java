package uit.tkorg.pr.centralcontroller;

import ir.vsr.HashMapVector;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.io.FileUtils;
import uit.tkorg.pr.constant.PRConstant;
import uit.tkorg.pr.dataimex.MASDataset1;
import uit.tkorg.pr.dataimex.MahoutFile;
import uit.tkorg.pr.dataimex.NUSDataset1;
import uit.tkorg.pr.dataimex.PRGeneralFile;
import uit.tkorg.pr.datapreparation.cbf.AuthorFVComputation;
import uit.tkorg.pr.datapreparation.cbf.PaperFVComputation;
import uit.tkorg.pr.datapreparation.cf.CFRatingMatrixComputation;
import uit.tkorg.pr.evaluation.Evaluator;
import uit.tkorg.pr.method.cbf.FeatureVectorSimilarity;
import uit.tkorg.pr.method.cf.KNNCF;
import uit.tkorg.pr.method.cf.SVDCF;
import uit.tkorg.pr.model.Author;
import uit.tkorg.pr.model.Paper;
import uit.tkorg.utility.general.BinaryFileUtility;
import uit.tkorg.utility.textvectorization.TextPreprocessUtility;
import uit.tkorg.utility.textvectorization.TextVectorizationByMahoutTerminalUtility;

/**
 *
 * @author THNghiep Central controller. Main entry class used for testing. Also
 * control all traffic from gui.
 */
public class PaperRecommender {

    public static void main(String[] args) {
        try {
            recommendationFlowController(PRConstant.FOLDER_MAS_DATASET1 + "[Training] Paper_Before_2006.csv",
                    PRConstant.FOLDER_MAS_DATASET1 + "[Training] Paper_Cite_Paper_Before_2006.csv",
                    PRConstant.FOLDER_MAS_DATASET1 + "[Testing] 1000Authors.csv",
                    PRConstant.FOLDER_MAS_DATASET1 + "[Testing] Ground_Truth_2006_2008_New_Citation.csv",
                    PRConstant.FOLDER_MAS_DATASET1 + "[Training] Author_Paper_Before_2006.csv",
                    PRConstant.FOLDER_MAS_DATASET1 + "[Training] Author_Cite_Paper_Before_2006.csv",
                    PRConstant.FOLDER_MAS_DATASET1 + "Text",
                    PRConstant.FOLDER_MAS_DATASET1 + "PreProcessedPaper",
                    PRConstant.FOLDER_MAS_DATASET1 + "Sequence",
                    PRConstant.FOLDER_MAS_DATASET1 + "Vector",
                    PRConstant.FOLDER_MAS_DATASET1 + "MahoutCF",
                    PRConstant.FOLDER_MAS_DATASET1 + "EvaluationResult\\EvaluationResult.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void recommendationFlowController(String fileNamePapers,
            String fileNamePaperCitePaper, String fileNameAuthorTestSet,
            String fileNameGroundTruth, String fileNameAuthorship, String fileNameAuthorCitePaper,
            String dirPapers, String dirPreProcessedPaper, String sequenceDir, String vectorDir,
            String MahoutCFDir, String fileNameEvaluationResult) throws Exception {

        long startRecommendationFlowTime = System.nanoTime();
        int topNRecommend = 100;

        // First: read list 1000 authors for test set.
        System.out.println("Begin reading author test set...");
        long startTime = System.nanoTime();
        HashMap<String, Author> authorTestSet = MASDataset1.readAuthorListTestSet(fileNameAuthorTestSet, fileNameGroundTruth, fileNameAuthorship);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Reading author test set elapsed time: " + estimatedTime / 1000000000 + " seconds");
        System.out.println("End reading author test set.");

        //<editor-fold defaultstate="collapsed" desc="CONTENT BASED METHOD">
        // Step 1:
        // - Read content of papers from [Training] Paper_Before_2006.csv
        // - Store metadata of all papers into HashMap<String, Paper> papers
        System.out.println("Begin reading paper list...");
        startTime = System.nanoTime();
        HashMap<String, Paper> papers = MASDataset1.readPaperList(fileNamePapers, fileNamePaperCitePaper);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Reading paper list elapsed time: " + estimatedTime / 1000000000 + " seconds");
        System.out.println("End reading paper list.");

        // Step 2:
        // - Writing abstract of all papers to text files. One file for each paper in 'dirPapers' directory.
        // - Clear abstract of all papers.
        System.out.println("Begin writing abstract to file...");
        startTime = System.nanoTime();
//        PRGeneralFile.writePaperAbstractToTextFile(papers, dirPapers);
        // Clear no longer in use objects.
        // Always clear abstract.
        PaperFVComputation.clearPaperAbstract(papers);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Writing abstract to file elapsed time: " + estimatedTime / 1000000000 + " seconds");
        System.out.println("End writing abstract to file.");

        // Step 3: Preprocessing content of all papers. Remove stop words and stemming
        System.out.println("Begin removing stopword and stemming...");
        startTime = System.nanoTime();
//        TextPreprocessUtility.parallelProcess(dirPapers, dirPreProcessedPaper, true, true);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Removing stopword and stemming elapsed time: " + estimatedTime / 1000000000 + " seconds");
        System.out.println("End removing stopword and stemming.");

        // Step 4: tf-idf. Output of this process is vectors of papers stored in a Mahout's binary file
        System.out.println("Begin vectorizing...");
        startTime = System.nanoTime();
//        TextVectorizationByMahoutTerminalUtility.textVectorizeFiles(dirPreProcessedPaper, sequenceDir, vectorDir);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Vectorizing elapsed time: " + estimatedTime / 1000000000 + " seconds");
        System.out.println("End vectorizing.");

        // Step 5: Read vectors of all papers store in
        // - HashMap<Integer, String> dictMap: Dictionary of the whole collection.
        // - HashMap<String, HashMapVector> vectorizedDocuments: <PaperID, Vector TF*IDF of PaperID>
        System.out.println("Begin reading vector...");
        startTime = System.nanoTime();
//        HashMap<Integer, String> dictMap = MahoutFile.readMahoutDictionaryFiles(vectorDir);
        HashMap<String, HashMapVector> vectorizedPapers = MahoutFile.readMahoutVectorFiles(vectorDir);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Reading vector elapsed time: " + estimatedTime / 1000000000 + " seconds");
        System.out.println("End reading vector.");

        // Step 6: put TFIDF vectors of all paper (vectorizedDocuments)
        // into HashMap<String, Paper> papers (model)
        System.out.println("Begin setting tf-idf to papers...");
        startTime = System.nanoTime();
        PaperFVComputation.setTFIDFVectorForAllPapers(papers, vectorizedPapers);
        // Clear no longer in use objects to free memory (although just procedure, underlying data are still in use).
//        dictMap = null;
        vectorizedPapers = null;
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Setting tf-idf to papers elapsed time: " + estimatedTime / 1000000000 + " seconds");
        System.out.println("End setting tf-idf to papers.");

        // Step 7: compute feature vector for those all 1000 authors.
        System.out.println("Begin computing authors FV...");
        startTime = System.nanoTime();
        HashSet<String> paperIdsOfAuthorTestSet = AuthorFVComputation.getPaperIdsOfAuthors(authorTestSet);
        PaperFVComputation.computeFeatureVectorForAllPapers(papers, paperIdsOfAuthorTestSet, 3, 0);
        AuthorFVComputation.computeFVForAllAuthors(authorTestSet, papers, 0, 0);
        // Clear no longer in use objects.
        PaperFVComputation.clearFV(papers);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Computing authors FV elapsed time: " + estimatedTime / 1000000000 + " seconds");
        System.out.println("End computing authors FV.");

        // Step 8: Aggregating feature vectors for all papers and
        // put the result into HashMap<String, Paper> papers (model)
        // (papers, 0, 0): baseline
        System.out.println("Begin computing FV for all papers...");
        startTime = System.nanoTime();
        HashSet<String> paperIdsTestSet = AuthorFVComputation.getPaperIdsTestSet(authorTestSet);
        PaperFVComputation.computeFeatureVectorForAllPapers(papers, paperIdsTestSet, 3, 0);
        HashMap<String, Paper> paperTestSet = PaperFVComputation.extractPapers(papers, paperIdsTestSet);
        // Clear no longer in use objects.
        PaperFVComputation.clearFV(papers);
        papers = null;
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Computing FV for all papers elapsed time: " + estimatedTime / 1000000000 + " seconds");
        System.out.println("End computing FV for all papers.");

        // Step 9: generate recommended papers list.
        System.out.println("Begin CBF Recommending...");
        startTime = System.nanoTime();
        FeatureVectorSimilarity.generateRecommendationForAllAuthors(authorTestSet, paperTestSet, 0, topNRecommend);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("CBF Recommending elapsed time: " + estimatedTime / 1000000000 + " seconds");
        System.out.println("End CBF Recommending.");
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="CF METHODS">
        /*
//        String MahoutCFFileOriginalFile = MahoutCFDir + "\\CFRatingMatrixOriginal.txt";
//        String MahoutCFRatingMatrixPredictionFile = null;

        // Read Raw rating matrix
//        HashMap<String, HashMap<String, Double>> authorPaperRating = MASDataset1.readAuthorCitePaperMatrix(fileNameAuthorCitePaper);

        // Normalize
//        System.out.println("Begin Normalize reating values in Citation Matrix");
//        CFRatingMatrixComputation.normalizeAuthorRatingVector(authorPaperRating);
//        System.out.println("End Normalize reating values in Citation Matrix");

        // Write to Mahout file
//        System.out.println("Begin writeCFRatingToMahoutFormatFile");
//        CFRatingMatrixComputation.writeCFRatingToMahoutFormatFile(authorPaperRating, MahoutCFFileOriginalFile);
//        System.out.println("End writeCFRatingToMahoutFormatFile");
        */

        /*
        // Predict ratings by kNNCF co-pearson.
        // k neighbors, get top n.
//        System.out.println("Begin CoPearsonRecommend");
//        int k = 8;

        // Recommend for all author in matrix.
//        MahoutCFRatingMatrixPredictionFile = MahoutCFDir + "\\CFRatingMatrixPredictionByCoPearson" + "k" + k + "n" + n + ".txt";
//        KNNCF.CoPearsonRecommend(MahoutCFFileOriginalFile, k, n, MahoutCFRatingMatrixPredictionFile);

        // Recommend for authors in author test set.
//        MahoutCFRatingMatrixPredictionFile = MahoutCFDir + "\\CFRatingMatrixPredictionByCoPearson" + "ForAuthorTestSet" + "k" + k + "n" + topNRecommend + ".txt";
//        KNNCF.CoPearsonRecommendToAuthorList(MahoutCFFileOriginalFile, k, topNRecommend, authorTestSet, MahoutCFRatingMatrixPredictionFile);
//        System.out.println("End CoPearsonRecommend");
        */

        /*
        // Predict ratings by SVD.
        // get top n, f features, normalize by l, i iterations.
//        System.out.println("Begin SVD Recommend");
//        int f = 50;
//        double l = 0.01;
//        int i = 1000;
        // Recommend for authors in author test set.
//        MahoutCFRatingMatrixPredictionFile = MahoutCFDir + "\\CFRatingMatrixPredictionBySVD" + "ForAuthorTestSet" + "n" + n + "f" + f + "l" + l + "i" + i + ".txt";
//        SVDCF.SVDRecommendationToAuthorList(MahoutCFFileOriginalFile, n, f, l, i, authorTestSet, MahoutCFRatingMatrixPredictionFile);
//        System.out.println("End SVD Recommend");
        */


        // Read Recommendation for 1000 authors, put it into authorTestSetList.
//        MahoutFile.readMahoutCFRating(MahoutCFRatingMatrixPredictionFile, authorTestSet);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="EVALUATION">
        // Compute evaluation index.
        System.out.println("Begin evaluating...");
        startTime = System.nanoTime();

        String algorithmName = "CB with FV_Papers(3,0) and FV_Authors(0,0)";
//        String algorithmName = "CF-CoPearson K=" + k;
//        String algorithmName = "CF SVD " + "n" + topNRecommend + "f" + f + "l" + l + "i" + i;

        double precision10 = Evaluator.computeMeanPrecisionTopN(authorTestSet, 10);
        double precision20 = Evaluator.computeMeanPrecisionTopN(authorTestSet, 20);
        double precision30 = Evaluator.computeMeanPrecisionTopN(authorTestSet, 30);
        double precision40 = Evaluator.computeMeanPrecisionTopN(authorTestSet, 40);
        double precision50 = Evaluator.computeMeanPrecisionTopN(authorTestSet, 50);
        double recall50 = Evaluator.computeMeanRecallTopN(authorTestSet, 50);
        double recall100 = Evaluator.computeMeanRecallTopN(authorTestSet, 100);
        double f1 = Evaluator.computeMeanFMeasure(authorTestSet, 1);
        double map10 = Evaluator.computeMAP(authorTestSet, 10);
        double map20 = Evaluator.computeMAP(authorTestSet, 20);
        double map30 = Evaluator.computeMAP(authorTestSet, 30);
        double map40 = Evaluator.computeMAP(authorTestSet, 40);
        double map50 = Evaluator.computeMAP(authorTestSet, 50);
        double ndcg5 = Evaluator.computeMeanNDCG(authorTestSet, 5);
        double ndcg10 = Evaluator.computeMeanNDCG(authorTestSet, 10);
        double mrr = Evaluator.computeMRR(authorTestSet);

        long estimatedRecommendationFlowTime = System.nanoTime() - startRecommendationFlowTime;

        StringBuilder evaluationResult = new StringBuilder();
        evaluationResult.append("Time Stamp").append("\t")
                .append("Algorithm").append("\t")
                .append("Running time in second").append("\t")
                .append("P@10").append("\t")
                .append("P@20").append("\t")
                .append("P@30").append("\t")
                .append("P@40").append("\t")
                .append("P@50").append("\t")
                .append("R@50").append("\t")
                .append("R@100").append("\t")
                .append("F1").append("\t")
                .append("MAP@10").append("\t")
                .append("MAP@20").append("\t")
                .append("MAP@30").append("\t")
                .append("MAP@40").append("\t")
                .append("MAP@50").append("\t")
                .append("NDCG@5").append("\t")
                .append("NDCG@10").append("\t")
                .append("MRR")
                .append("\r\n")
                .append(new Date(System.currentTimeMillis()).toString()).append("\t")
                .append(algorithmName).append("\t")
                .append(estimatedRecommendationFlowTime / 1000000000).append("\t")
                .append(precision10).append("\t")
                .append(precision20).append("\t")
                .append(precision30).append("\t")
                .append(precision40).append("\t")
                .append(precision50).append("\t")
                .append(recall50).append("\t")
                .append(recall100).append("\t")
                .append(f1).append("\t")
                .append(map10).append("\t")
                .append(map20).append("\t")
                .append(map30).append("\t")
                .append(map40).append("\t")
                .append(map50).append("\t")
                .append(ndcg5).append("\t")
                .append(ndcg10).append("\t")
                .append(mrr)
                .append("\r\n");
        FileUtils.writeStringToFile(new File(fileNameEvaluationResult), evaluationResult.toString(), "UTF8", true);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Evaluating elapsed time: " + estimatedTime / 1000000000 + " seconds");
        System.out.println("End evaluating.");
        //</editor-fold>

    }

    /**
     * This method handles all request from gui.
     *
     * @param request
     * @param param
     * @return response: result of request after processing.
     */
    public String[] guiRequestHandler(String request, String param) {

        HashMap<String, Paper> papers = new HashMap<>();
        HashMap<String, Author> authors = new HashMap<>();
        HashMap<String, Paper> papersOfAuthors = new HashMap<>();

        String[] response = new String[2];

        String Dataset1Folder;
        String SaveDataFolder;

        try {
            switch (request) {

                // Dataset 1: data import.
                case "Read paper":
                    // Read param to get dataset 1 folder.
                    if ((param != null) && !(param.isEmpty())) {
                        Dataset1Folder = param;
                    } else {
                        Dataset1Folder = PRConstant.FOLDER_NUS_DATASET1;
                    }
                    papers = NUSDataset1.buildListOfPapers(Dataset1Folder);
                    response[0] = "Success.";
                    break;
                case "Read author":
                    // Read param to get dataset 1 folder.
                    if ((param != null) && !(param.isEmpty())) {
                        Dataset1Folder = param;
                    } else {
                        Dataset1Folder = PRConstant.FOLDER_NUS_DATASET1;
                    }
                    authors = NUSDataset1.buildListOfAuthors(Dataset1Folder);
                    papersOfAuthors = AuthorFVComputation.getPapersFromAuthors(authors);
                    response[0] = "Success.";
                    break;
                case "Save paper":
                    // Read param to get save data folder.
                    if ((param != null) && !(param.isEmpty())) {
                        SaveDataFolder = param;
                    } else {
                        SaveDataFolder = PRConstant.SAVEDATAFOLDER;
                    }
                    BinaryFileUtility.saveObjectToFile(papers, SaveDataFolder + "\\Papers.dat");
                    response[0] = "Success.";
                    break;
                case "Save author":
                    // Read param to get save data folder.
                    if ((param != null) && !(param.isEmpty())) {
                        SaveDataFolder = param;
                    } else {
                        SaveDataFolder = PRConstant.SAVEDATAFOLDER;
                    }
                    BinaryFileUtility.saveObjectToFile(authors, SaveDataFolder + "\\Authors.dat");
                    response[0] = "Success.";
                    break;
                case "Load paper":
                    // Read param to get save data folder.
                    if ((param != null) && !(param.isEmpty())) {
                        SaveDataFolder = param;
                    } else {
                        SaveDataFolder = PRConstant.SAVEDATAFOLDER;
                    }
                    papers = (HashMap<String, Paper>) BinaryFileUtility.loadObjectFromFile(SaveDataFolder + "\\Papers.dat");
                    response[0] = "Success.";
                    break;
                case "Load author":
                    // Read param to get save data folder.
                    if ((param != null) && !(param.isEmpty())) {
                        SaveDataFolder = param;
                    } else {
                        SaveDataFolder = PRConstant.SAVEDATAFOLDER;
                    }
                    authors = (HashMap<String, Author>) BinaryFileUtility.loadObjectFromFile(SaveDataFolder + "\\Authors.dat");
                    papersOfAuthors = AuthorFVComputation.getPapersFromAuthors(authors);
                    response[0] = "Success.";
                    break;

                // Dataset 1: data preparation.
                case "Paper FV linear":
                    PaperFVComputation.computeFeatureVectorForAllPapers(papers, null, 3, 0);
                    response[0] = "Success.";
                    break;
                case "Paper FV cosine":
                    PaperFVComputation.computeFeatureVectorForAllPapers(papers, null, 3, 1);
                    response[0] = "Success.";
                    break;
                case "Paper FV RPY":
                    PaperFVComputation.computeFeatureVectorForAllPapers(papers, null, 3, 2);
                    response[0] = "Success.";
                    break;
                case "Author FV linear":
                    PaperFVComputation.computeFeatureVectorForAllPapers(papersOfAuthors, null, 3, 0);
                    AuthorFVComputation.computeFVForAllAuthors(authors, papersOfAuthors, 0, 0);
                    response[0] = "Success.";
                    break;
                case "Author FV cosine":
                    PaperFVComputation.computeFeatureVectorForAllPapers(papersOfAuthors, null, 3, 1);
                    AuthorFVComputation.computeFVForAllAuthors(authors, papersOfAuthors, 0, 0);
                    response[0] = "Success.";
                    break;
                case "Author FV RPY":
                    PaperFVComputation.computeFeatureVectorForAllPapers(papersOfAuthors, null, 3, 2);
                    AuthorFVComputation.computeFVForAllAuthors(authors, papersOfAuthors, 0, 0);
                    response[0] = "Success.";
                    break;
                case "Recommend":
                    FeatureVectorSimilarity.generateRecommendationForAllAuthors(authors, papers, 0, 10);
                    response[0] = "Success.";
                    break;
                case "NDCG5":
                    response[1] = String.valueOf(Evaluator.computeMeanNDCG(authors, 5));
                    response[0] = "Success.";
                    break;
                case "NDCG10":
                    response[1] = String.valueOf(Evaluator.computeMeanNDCG(authors, 10));
                    response[0] = "Success.";
                    break;
                case "MRR":
                    response[1] = String.valueOf(Evaluator.computeMRR(authors));
                    response[0] = "Success.";
                    break;
                default:
                    response[0] = "Unknown.";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
            response[0] = "Fail.";
            return response;
        }

        return response;
    }
}