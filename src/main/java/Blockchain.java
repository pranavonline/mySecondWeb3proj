import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;

import java.util.concurrent.ExecutionException;

public class Blockchain {
    private static final String DEFAULT_ADDRESS = "https://blue-cosmopolitan-log.ethereum-sepolia.discover.quiknode.pro/07283818e409eb38d967efaa4dd3c82566b73578/";
    static Web3j myEtherWallet = Web3j.build(new HttpService(DEFAULT_ADDRESS));

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       System.out.println("EthBlockNumber --> " + getBlockNumber().getBlockNumber());
       System.out.println("EthAccounts --> " + getEthAccounts().getAccounts().toString());
       System.out.println("EthGetBalance --> " + getEthBalance().getRawResponse());
    }

    public static EthBlockNumber getBlockNumber() throws ExecutionException, InterruptedException {
        return myEtherWallet.ethBlockNumber()
                .sendAsync()
                .get();
    }

    public static EthAccounts getEthAccounts() throws ExecutionException, InterruptedException {
        return myEtherWallet.ethAccounts()
                .sendAsync()
                .get();
    }

    public static EthGetBalance getEthBalance() throws ExecutionException, InterruptedException {
        return myEtherWallet.ethGetBalance(DEFAULT_ADDRESS,
                        DefaultBlockParameter.valueOf("latest"))
                .sendAsync()
                .get();
    }
}
