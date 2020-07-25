package com.xiaolong.nlp;
import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.*;

/*
Part of speech for each string's generator.
hey -> NN
! -> .
I -> PRP
am -> VBP
Xiaolong -> NNP
Li -> NNP
. -> .
 */

public class PartOfSpeechExample {
    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        String text = "I am Xiaolong from SLS.";

        CoreDocument coreDocument = new CoreDocument(text);

        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabelList = coreDocument.tokens();

        for (CoreLabel coreLabel : coreLabelList) {
            //String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            System.out.println(coreLabel.originalText() + " -> " + pos);
        }
    }
}

