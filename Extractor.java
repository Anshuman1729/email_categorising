import java.io.*;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class Extractor {

    public static void main(String[] args) throws Exception{


        InputStream in = new FileInputStream("models/en-token.bin");
        TokenizerModel mo = new TokenizerModel(in);

        TokenizerME tokenize = new TokenizerME(mo);

        BufferedReader read = new BufferedReader(new FileReader("Emails.txt"));
        String text;
        while ((text = read.readLine()) != null){

            String[] tokens = tokenize.tokenize(text);

            for(String token:tokens){
                System.out.print(token + ", ");
            }

        }
        read.close();

    }

}

