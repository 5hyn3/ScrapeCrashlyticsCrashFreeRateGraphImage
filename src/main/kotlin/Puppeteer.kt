import kotlin.js.Json
import kotlin.js.Promise

@Suppress("FunctionName")
@JsModule("puppeteer")
external object Puppeteer {
    class Page {
        fun goto(url: String, options: dynamic): Promise<dynamic>
        fun waitFor(element: String, options: dynamic): Promise<dynamic>
        fun setCookie(json: Json): Promise<dynamic>
        fun waitFor(num: Int): Promise<dynamic>
        fun waitForNavigation(options: Json): Promise<dynamic>
        fun waitForXPath(xpath: String, options: dynamic): Promise<dynamic>
        fun content(): Promise<dynamic>
        fun type(selector: dynamic, string: String): Promise<dynamic>
        fun click(selector: dynamic): Promise<dynamic>
        fun close(): Promise<dynamic>
        fun evaluate(pageFunction: Function<dynamic>): Promise<dynamic>
        fun screenshot(path: Json): Promise<dynamic>
    }

    class Browser {
        fun newPage(): Promise<Page>
        fun close(): Promise<dynamic>
        fun wsEndpoint(): String
    }

    fun launch(options: dynamic): Promise<Browser>
}
