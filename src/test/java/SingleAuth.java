import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
public class SingleAuth {
    PlaywrightContext playwrightFactory = new PlaywrightContext();

    public void loginBeforeSuite() {
        loginNStore("username1","Password1","username1.json");
        loginNStore("username2","Password2","username2.json");
    }

    public void loginNStore(String username, String password, String filename) {

        playwrightFactory.initBrowser(null);
        Page page=playwrightFactory.getPage();

        //Code to login into a website

        BrowserContext context=playwrightFactory.getBrowserContext();
        context.storageState(new BrowserContext.StorageStateOptions()
                .setPath(Paths.get(filename+".json")));
        context.close();
    }
}
