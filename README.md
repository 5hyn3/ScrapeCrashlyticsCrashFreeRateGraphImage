# ScrapeCrashlyticsCrashFreeRateGraphImage

Kotlin/JSでPuppeteerを触ってみたコードです。  
Chromiumを操作し、指定されたFirebaseCrashlyticsのダッシュボードのURLからクラッシュフリーレートのグラフの画像を取得します。

## 環境
`node v12.18.3`を利用して開発及び動作の確認をしています

## 使い方

1. パラメータを埋める
    - src/main/kotlin/main.kt内の`CrashlyticsDashBoardUrl`変数
      - CrashlyticsのダッシュボードのURLを入力してください
    - src/main/kotlin/cookies.kt内の`cookies`変数
      - Firebaseにログインした状態のCookieの配列をjson形式で入力してください
2. `./gradlew run`
3. `screenshot.png`という名前でプロジェクトのルートにクラッシュフリーレートのグラフの画像が生成されます

付属のDockerfileを利用して実行する場合は以下の箇所で渡しているjsonに`"executablePath" to "/usr/bin/google-chrome"`を追加してください  
https://github.com/5hyn3/ScrapeCrashlyticsCrashFreeRateGraphImage/blob/main/src/main/kotlin/main.kt#L10-L13

## 参考

[Qiita - バックグラウンドで使うpuppeteer with Kotlin](https://qiita.com/numa08/items/214c6c9d06d5094add3a)
