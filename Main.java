import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    
    public static void main( String[] args ) 
                    throws UnknownHostException, IOException {

        ServerSocket server = new ServerSocket(3322);                       
        System.out.println( "Server initialized in port 3322" );
        
        Socket client = server.accept();
        System.out.println( "Client connected from IP:" + client.getInetAddress().getHostAddress() );

        Scanner reader = new Scanner( System.in );
        PrintStream output = new PrintStream( client.getOutputStream() );
        Scanner input = new Scanner( client.getInputStream() );

        while ( input.hasNextLine() || reader.hasNextLine() ) {
            System.out.println( input.nextLine() );
            output.println( reader.nextLine() );
        }
        
        input.close();
        output.close();
        reader.close();
        server.close();
    }
    
}