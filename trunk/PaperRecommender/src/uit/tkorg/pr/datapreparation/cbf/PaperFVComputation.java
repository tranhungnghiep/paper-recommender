/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.pr.datapreparation.cbf;

import ir.vsr.HashMapVector;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import uit.tkorg.pr.model.Paper;
import uit.tkorg.utility.general.WeightingUtility;

/**
 *
 * @author THNghiep 
 * This class handles logic to compute feature vector of all papers.
 * Method: 
 * - Compute papers' full vector: its content itself or combining its refs and cits by linear, cosine, rpy.
 */
public class PaperFVComputation {

    // Prevent instantiation.
    private PaperFVComputation() {}

    public static void clearPaperAbstract(HashMap<String, Paper> papers) throws Exception {
        for (String paperId : papers.keySet()) {
            papers.get(paperId).setPaperAbstract(null);
        }
    }

    public static void setTFIDFVectorForAllPapers(HashMap<String, Paper> papers, HashMap<String, HashMapVector> vectorizedDocuments) throws Exception {
        for (String paperId : papers.keySet()) {
            papers.get(paperId).setTfidfVector(vectorizedDocuments.get(paperId));
        }
    }

    /**
     * This method computes and set value for all papers' full feature vector
     * (after combining citation and reference papers).
     *
     * @param combiningScheme   0: itself content, 1: itself content + content of references; 
     *                          2: itself content + content of citations; 3: itself content + content of references + content of citations.
     * @param weightingScheme   0: linear; 1: cosine; 2: rpy
     */
    public static void computeFeatureVectorForAllPapers(HashMap<String, Paper> papers, int combiningScheme, int weightingScheme) throws Exception {
        // Current paper.
        int count = 0;
        System.out.println("Number of papers: " + papers.size());

        for (String paperId : papers.keySet()) {
            // Print current paper number.
            if (count % 1000 == 0) {
                System.out.println("Compting FV for paper No. " + (count + 1));
            }
            count++;

            computePaperFV(papers, paperId, combiningScheme, weightingScheme);
        }
    }

    /**
     * This method compute final feature vector by combining citation and
     * reference.
     *
     * @param paperId
     * @return list represents feature vector.
     */
    public static void computePaperFV(HashMap<String, Paper> papers, String paperId, int combiningScheme, int weightingScheme) throws Exception {

        papers.get(paperId).setFeatureVector(new HashMapVector());
        papers.get(paperId).getFeatureVector().add(papers.get(paperId).getTfidfVector());// add tfidf to zero vector, not assign
        
        // weighting scheme
        if (weightingScheme == 0) {
            if (combiningScheme == 1) {
                sumFVLinear(papers, paperId, papers.get(paperId).getReference());
            } else if (combiningScheme == 2) {
                sumFVLinear(papers, paperId, papers.get(paperId).getCitation());
            } else if (combiningScheme == 3) {
                sumFVLinear(papers, paperId, papers.get(paperId).getReference());
                sumFVLinear(papers, paperId, papers.get(paperId).getCitation());
            }
        } else if (weightingScheme == 1) {
            if (combiningScheme == 1) {
                sumFVCosine(papers, paperId, papers.get(paperId).getReference());
            } else if (combiningScheme == 2) {
                sumFVCosine(papers, paperId, papers.get(paperId).getCitation());
            } else if (combiningScheme == 3) {
                sumFVCosine(papers, paperId, papers.get(paperId).getReference());
                sumFVCosine(papers, paperId, papers.get(paperId).getCitation());
            }
        } else if (weightingScheme == 2) {
            if (combiningScheme == 1) {
                sumFVRPY(papers, paperId, papers.get(paperId).getReference());
            } else if (combiningScheme == 2) {
                sumFVRPY(papers, paperId, papers.get(paperId).getCitation());
            } else if (combiningScheme == 3) {
                sumFVRPY(papers, paperId, papers.get(paperId).getReference());
                sumFVRPY(papers, paperId, papers.get(paperId).getCitation());
            }
        }
    }

    /**
     * This method compute sum of Papers(Citation or Reference Paper) with
     * linear weight
     *
     * @param combiningPaperIds
     * @return featureVector
     */
    private static void sumFVLinear(HashMap<String, Paper> papers, String paperId, List<String> combiningPaperIds) throws Exception {
        for (String combiningPaperId : combiningPaperIds) {
            if (papers.containsKey(combiningPaperId)) {
                papers.get(paperId).getFeatureVector().add(papers.get(combiningPaperId).getTfidfVector());
            }
        }
    }

    /**
     * This method compute sum of Papers(Citation or Reference Paper) with
     * cosine weight
     *
     * @param paper
     * @param combiningPaperIds
     * @return featureVector
     */
    private static void sumFVCosine(HashMap<String, Paper> papers, String paperId, List<String> combiningPaperIds) throws Exception {
        for (String combiningPaperId : combiningPaperIds) {
            if (papers.containsKey(combiningPaperId)) {
                double cosine = WeightingUtility.computeCosine(papers.get(paperId).getTfidfVector(), papers.get(combiningPaperId).getTfidfVector());
                papers.get(paperId).getFeatureVector().addScaled(papers.get(combiningPaperId).getTfidfVector(), cosine);
            }
        }
    }

    /**
     * This method compute sum of Papers(Citation or Reference Paper) with rpy
     * weight
     *
     * @param paper
     * @param combiningPaperIds
     * @return featureVector
     */
    private static void sumFVRPY(HashMap<String, Paper> papers, String paperId, List<String> combiningPaperIds) throws Exception {
        for (String combiningPaperId : combiningPaperIds) {
            if (papers.containsKey(combiningPaperId)) {
                double rpy = WeightingUtility.computeRPY(papers.get(paperId).getYear(), papers.get(combiningPaperId).getYear(), 0.9);
                papers.get(paperId).getFeatureVector().addScaled(papers.get(combiningPaperId).getTfidfVector(), rpy);
            }
        }
    }
}
