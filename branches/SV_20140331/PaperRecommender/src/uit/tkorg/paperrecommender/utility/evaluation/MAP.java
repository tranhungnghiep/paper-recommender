/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.paperrecommender.utility.evaluation;

import java.util.HashMap;
import java.util.List;
import uit.tkorg.paperrecommender.model.Author;

/**
 *
 * @author Vinh-PC
 */
public class MAP {

    // Prevent instantiation.
    private MAP() {
    }

    /**
     * This method computes average precision with threshold k
     *
     * @param rankList
     * @param idealList
     * @param k
     * @return ap
     */
    public static double computeAP(List rankList, List idealList, int k) {
        double ap = 0;

        if (k > rankList.size()) {
            k = rankList.size();
        }

        for (int i = 0; i < k; i++) {
            ap += Precision.computePrecisionK(rankList, idealList, i + 1);
        }
        ap = (double) ap / k;

        return ap;
    }
}
