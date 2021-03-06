package com.example.yuichi_oba.ecclesia.tools;

public class Hint {
    /***
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * _/_/_/
     * _/_/_/         Spinner値の動的設定
     * _/_/_/
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     *      ①   リスト作成（スピナーに設定したい型でーー＞ま、ふつうList<String> ）
     *      ②   ArrayAdapter<String> adapter = new ...(this, android.R.layout.simple..., list);
     *      ③   spinner.setAdapter(adapter)で OK!
     *
     *      cf) リスナー setOnItemSelectedListener
     *                  Spinner spinner = (Spinner) adapterView;
     *                  String name = spinner.getSelectedItem().toString();
     *
     *
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * _/_/_/
     * _/_/_/          DB検索
     * _/_/_/
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     *      ①   SQLiteOpenHelper helper = new DB(getApplicationContext());
     *      ②   SQLiteDatabase db = helper.getReadableDatabase();   // 読み取り専用
     *                                                               // 書き込みたいなら、getWritable~~~();
     *      ③   Cursor c = rawQuery("SQL文", ?に該当するやつ（new String[]{});
     *      ④   if (c.moveToNext()){...} or while (c.moveToNext()){...}
     *
     *
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * _/_/_/
     * _/_/_/           Intentでの値渡し ＋ オブジェクト渡し
     * _/_/_/
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     *      ①   Inten in = new Intent(getApplicationContext(), 次の画面のクラス名.class);
     *      ②   intent.putExtra("key", object);
     *
     *      ③   遷移後のアクティビティでのオブジェクト受け取り
     *      ④   Intent in = getIntent();;
     *      ⑤   ex)     StoreData s = (StoreData) intent.getSerializableExtra(key)
     *                   このとき、StoreDataは "implements Serializable" する
     *                   Bundle も同じ！
     *
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * _/_/_/
     * _/_/_/           ダイアログ
     * _/_/_/
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     *      ①   MyDialog extends DialogFragment {...}
     *      ②   onCreateDialog を　オーバーライド
     *      ③   基本形の例
                        @Override
                        public Dialog onCreateDialog(Bundle savedInstanceState) {
                        return new AlertDialog.Builder(getActivity())
                        .setTitle("タイトル")
                        .setMessage("メッセージ")
                        .create();
                        }

                         @Override
                         public void onPause() {
                         super.onPause();

                         // onPause でダイアログを閉じる場合
                         dismiss();
                         }

            ④   使用する際は、
                         MyDialog d = new MyDialog();
                         d.show(getFragmentManager(), "key");

            ⑤   ダイアログにリストを出す
                 .setItems(items, new DialogInterface.OnClickLister(){...}
             CharSequence[] items =
                reserveInfo.getRe_member().toArray(new CharSequence[reserveInfo.getRe_member().size()]);

     *
     *
     */
}
