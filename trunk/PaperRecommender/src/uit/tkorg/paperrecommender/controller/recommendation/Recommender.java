/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.paperrecommender.controller.recommendation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import uit.tkorg.paperrecommender.model.Author;
import uit.tkorg.paperrecommender.model.Paper;
import uit.tkorg.paperrecommender.utility.General;
import uit.tkorg.paperrecommender.utility.Weighting;

/**
 * This class handles logic for recommending papers to each author.
 * Data: none.
 * Method: 
 * - buildAllRecommendationLists: 
 * + input: list of authors, list of papers.
 * + output: list of authors with recommendation list included, also includes all data of the input list of authors.
 * @author THNghiep
 */
public class Recommender {
    /**
     * This method runs recommendation business.
     * @param authorsInput
     * @param papers
     * - For each author:
     * + Compute similarity with all papers.
     * + Sort list of papers, based on similarity.
     * + Take top ten papers with highest similarity for the recommendation list.
     * + Save recommendation list into current author.
     * - Finish all authors, return the hashmap.
     * @return authors: list of authors with all input data plus recommendation list.
     */
    public HashMap<String, Author> buildAllRecommendationLists(HashMap authorsInput, HashMap papers) {
        HashMap<String, Author> authors = new HashMap(authorsInput);
        List<String> recommendationPapers = null;
        for (String key : authors.keySet()) {
            recommendationPapers = buildRecommdationList(authors.get(key), papers);
            authors.get(key).setRecommendation(recommendationPapers);
        }
        return authors;
    }

    /**
     * This method build list of 10 papers to recommend to an author.
     * @param author: current author
     * @param papers: hashmap of all papers to recommend.
     * @return recommendationPapers
     */
    private List<String> buildRecommdationList(Author author, HashMap<String, Paper> papers) {
        List<String> recommendationPapers = new ArrayList();
        LinkedHashMap<String, Double> paperSimilarity = new LinkedHashMap();
        
        // Compute similarities between current author and all papers.
        for (String key : papers.keySet()) {
            Double similarity = new Double(Weighting.computeCosine(author.getFeatureVector(), papers.get(key).getFeatureVector()));
            paperSimilarity.put(key, similarity);
        }
        
        // Sort papers descending based on similarity.
        paperSimilarity = General.sortHashMap(paperSimilarity);
        
        // Take top ten papers.
        int counter = 0;
        for (String paperId : paperSimilarity.keySet()) {
            recommendationPapers.add(paperId);
            counter++;
            if (counter >= 10) {
                break;
            }
        }
        
        return recommendationPapers;
    }
    
}
