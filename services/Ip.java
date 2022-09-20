package services;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ip {

    
    //Vai validar o ip, endereço do Protocolo de Internet.
    public static Boolean validatedIp(String endereco) {
        String[] numbers = endereco.split("\\.");

        if(numbers.length != 4){
            System.out.println(String.format("Endereço IP é inválido [ %s ]!", endereco));
            return false;
        }

        for(String number: numbers){
            int numero = Integer.parseInt(number);

            if(numero < 0 || numero > 255){
                return false;
            }
        }

        return true;
    }

    public static void myIpAndHost() {
        try {
            InetAddress myAdress = InetAddress.getLocalHost();

            System.out.println("--------------------------------");
            System.out.println(myAdress.getHostAddress());
            System.out.println(myAdress.getHostName());
            System.out.println("--------------------------------");

        } catch(UnknownHostException ex) {
            System.out.println("Desconhecido host: " + ex.getMessage());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
