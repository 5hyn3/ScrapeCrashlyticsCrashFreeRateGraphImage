import kotlinx.browser.document
import kotlin.js.Json
import kotlin.js.json

private const val CrashlyticsDashBoardUrl = "CrashlyticsのダッシュボードのURLを入力してください"

fun main() {
    async {
        val browser = Puppeteer.launch(
            json(
                "devtools" to true,
                "args" to arrayOf("--no-sandbox", "--disable-setuid-sandbox")
            )
        ).await()
        try {
            val page = browser.newPage().await()

            for (cookie: Json in cookies) {
                page.setCookie(cookie).await()
            }

            page.goto(
                CrashlyticsDashBoardUrl,
                json(
                    "timeout" to 1000000
                )
            ).await()
            page.waitForNavigation(
                json(
                    "timeout" to 1000000,
                    "waitUntil" to "networkidle0"
                )
            ).await()

            val crashFreeRateGraphRectString = page.evaluate {
                val elementRect = document.querySelector(
                    "#main > fire-router-outlet > crashlytics-index > c9s-issues > c9s-issues-index > div > div > div > c9s-issues-metrics > div > mat-card.crash-free-container.mat-card.mat-focus-indicator"
                )?.getBoundingClientRect()
                return@evaluate JSON.stringify(elementRect)
            }.await() as String

            val crashFreeRateGraphRect = JSON.parse<Json>(crashFreeRateGraphRectString)

            page.screenshot(
                json(
                    "path" to "screenshot.png",
                    "clip" to crashFreeRateGraphRect
                )
            ).await()
        } finally {
            browser.close().await()
        }
    }
}
