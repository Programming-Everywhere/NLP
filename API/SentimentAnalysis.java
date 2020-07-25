package com.xiaolong.nlp;


import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

/*

customer feedback can be used here.
project review.


Negative : Hello this is Xiaolong.
Positive : I really really love New York.

 */

public class SentimentAnalysis {

    public static void main(String[] args) {

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        String text = "Hello this is Spiderman. I really really love MJ.";

        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreSentence> sentenceList = coreDocument.sentences();

        for (CoreSentence sentence: sentenceList) {

            String sentiment = sentence.sentiment();

            System.out.println(sentiment+ " : "+ sentence);
        }
    }
}

