import java.io.*;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class Extractor {

    public static void main(String[] args) throws Exception{


        /**
         * Add the tokenizer training model
         * initialize the tokenizer model to the input training model
         */
        InputStream in = new FileInputStream("models/en-token.bin");
        TokenizerModel mo = new TokenizerModel(in);

        //Creating a tokenizer object
        TokenizerME tokenize = new TokenizerME(mo);

        //Email text
//        String email = "Hi there this is the email text.";
        BufferedReader read = new BufferedReader(new FileReader("Emails.txt"));
        String text;
        while ((text = read.readLine()) != null){

            //Tokenize the email
            String[] tokens = tokenize.tokenize(text);

            //Print the tokens
            for(String token:tokens){
                System.out.print(token + ", ");
            }

        }
        read.close();

    }

}
