# ScrapeCrashlyticsCrashFreeRateGraphImage

Kotlin/JSでPuppeteerを触ってみたコードです。  
Chromiumを操作し、指定されたFirebaseCrashlyticsのダッシュボードのURLからクラッシュフリーレートのグラフの画像を取得します。

## 使い方

1. パラメータを埋める
    - src/main/kotlin/main.kt内の`CrashlyticsDashBoardUrl`変数
      - CrashlyticsのダッシュボードのURLを入力してください
    - src/main/kotlin/cookies.kt内の`cookies`変数
      - Firebaseにログインした状態のCookieの配列をjson形式で入力してください
2. `./gradlew run`
3. `screenshot.png`という名前でプロジェクトのルートにクラッシュフリーレートのグラフの画像が生成されます

## 参考

[Qiita - バックグラウンドで使うpuppeteer with Kotlin](https://qiita.com/numa08/items/214c6c9d06d5094add3a)
