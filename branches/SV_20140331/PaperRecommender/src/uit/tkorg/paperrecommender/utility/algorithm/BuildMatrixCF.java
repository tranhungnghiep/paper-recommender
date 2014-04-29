/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.paperrecommender.utility.algorithm;

import uit.tkorg.paperrecommender.model.Paper;
import uit.tkorg.paperrecommender.model.Author;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import uit.tkorg.paperrecommender.utility.Weighting;
import uit.tkorg.paperrecommender.utility.GeneralUtility;
import uit.tkorg.paperrecommender.utility.PearsonCorrelation;
import uit.tkorg.paperrecommender.utility.algorithm.Knn;
import uit.tkorg.paperrecommender.utility.algorithm.Distance;

/**
 *
 * @author Minh
 */

public class BuildMatrixCF {
    /**
     * This is method impute value to full matrix
     *
     * @param matrixBuild
     * @param neighborhood
     * @return full matrix
     * @throws Exception
     */
    public static double[][] imputeFullMatrix(List <Paper> items,double[][] matrixInput, int neighbor) throws Exception {
        HashMap arrayPearson = new HashMap();
        List<String> listNeighbor = new ArrayList();
        for (int i = 0; i < matrixInput.length; i++) {
            arrayPearson =Distance.pearsonPaperTarget(items,matrixInput, i);
            listNeighbor = Knn.nearestPapers(arrayPearson,neighbor );
            double numerator = 0;
            double  sumPCCNeighbor =0;
            for (int j = 0; j < matrixInput[i].length; j++) {
                if (i == j) {
                    matrixInput[i][j] = 1.00;
                } else {
                    for (int l = 0; l < matrixInput.length; l++) {
                        for (int k = 0; k < neighbor; k++) {
                            if (listNeighbor.get(k) == items.get(l).getPaperId()) {
                                numerator +=((double) arrayPearson.get(listNeighbor.get(k)) * (matrixInput[l][j] - PearsonCorrelation.mean(matrixInput[l])));
                                sumPCCNeighbor += (double)arrayPearson.get(listNeighbor.get(k));
                            }
                        }
                    }
                   matrixInput[i][j] = PearsonCorrelation.mean(matrixInput[i]) + numerator / sumPCCNeighbor;
                   matrixInput[j][i] = matrixInput[i][j];
                }
            }
        }
        return matrixInput;
    }
}
