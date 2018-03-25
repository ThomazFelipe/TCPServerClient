import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main( String[] args ) 
                    throws UnknownHostException, IOException {

        Socket client = new Socket( "127.0.0.1", 3322 );
        System.out.println( "The client connected!" );

        Scanner reader = new Scanner( System.in );
        PrintStream output = new PrintStream( client.getOutputStream() );
        Scanner input = new Scanner( client.getInputStream() );

        while ( reader.hasNextLine() || input.hasNextLine() ) {
            output.println( reader.nextLine() );
            System.out.println( input.nextLine() );
        }

        input.close();
        output.close();
        reader.close();
        client.close();
    }
}