package com.xiaolong.nlp;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class SentenceRecognizer {

    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        String text = "hey! I am Xiaolong. I am a SLS in Austin, and I love food.";

        CoreDocument coreDocument = new CoreDocument(text);

        stanfordCoreNLP.annotate(coreDocument);

        List <CoreSentence> sentences = coreDocument.sentences();

        for(CoreSentence sentence: sentences) {
            System.out.println(sentence.toString());
        }
    }
}

