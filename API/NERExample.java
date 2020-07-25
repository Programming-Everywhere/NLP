package com.xiaolong.nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

//works for chatbot,-> I am Xiaolong. chatbot: hello Xiaolong,

/*
Named Entity Recognition:
Hello = O
, = O
I = O
am = O
Xiaolong = PERSON
and = O
I = O
am = O
friend = O
of = O
Vini = PERSON
Granja = PERSON
. = O
We = O
both = O
are = O
working = O
for = O
Google = ORGANIZATION
and = O
living = O
in = Oa
New = STATE_OR_PROVINCE
York = STATE_OR_PROVINCE
 */

public class NERExample {

    public static void main(String[] args) {

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        String text = "Hello, this Xiaolong, Matt and Sonia." + " We are working for Google and living in Austin, New York in the US" ;

        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);


        List<CoreLabel> coreLabelList = coreDocument.tokens();

        for (CoreLabel coreLable : coreLabelList) {
            String ner = coreLable.get(CoreAnnotations.NamedEntityTagAnnotation.class);
            System.out.println(coreLable.originalText() + " = " + ner);
        }
    }

}

