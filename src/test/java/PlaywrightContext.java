import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class PlaywrightContext {
    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static  ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static  ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static  ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    Browser.NewContextOptions newContextOptions;
    public static Browser getBrowser(){
        return tlBrowser.get();
    }

    public static BrowserContext getBrowserContext(){
        return tlBrowserContext.get();
    }

    public static void setBrowserContext(BrowserContext context) {
        tlBrowserContext.set(context);
    }

    public static Page getPage(){
        return tlPage.get();
    }

    public static void setPage(Page page) {
        tlPage.set(page);
    }

    public static Playwright getPlaywright(){
        return tlPlaywright.get();
    }

    public void initBrowser(String login_user){
        tlPlaywright.set(Playwright.create());
        tlBrowser.set( getPlaywright().chromium().launch());
        if(login_user!=null)
            tlBrowserContext.set(getBrowser().newContext(
                    new Browser.NewContextOptions().setStorageStatePath(Paths.get(login_user))));
        else
            tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions()));
        tlPage.set(getBrowserContext().newPage());

    }
}
