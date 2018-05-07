package hw.demo;

import sapphire.kernel.server.KernelServerImpl;
import sapphire.runtime.Sapphire;

import java.net.InetSocketAddress;

import static sapphire.runtime.Sapphire.new_;

public class accountant {
    public static void main(String[] args) {
        System.out.println("Hello transaction demo");

        System.out.println("creating local Sapphire runtime env...");
        InetSocketAddress host = new InetSocketAddress("127.0.0.1", 55555);
        InetSocketAddress oms = new InetSocketAddress("127.0.0.1", 55556);
        KernelServerImpl kernelServer = new KernelServerImpl(host, oms);

        wallet wallet = new wallet();
        //wallet.credit(100);
        bankaccount bankaccount = new bankaccount();

        System.out.println("creating the fainance object...");
        finance finance = (finance) new_(hw.demo.finance.class,wallet, bankaccount);

        System.out.println("trnasfering fund between 2 entities...");
        try {
            finance.transferFromWallet(5);
        }catch (Exception e) {
            System.err.println(e.toString());
        }

        System.out.printf("finance details: %s\r\n", finance.getDetails());
    }
}