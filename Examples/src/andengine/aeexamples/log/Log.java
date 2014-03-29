package andengine.aeexamples.log;

/**
 * Created by Igor Kupchenko on 24.06.13.
 */
public class Log {

    public static final String TAG = "my_ae_example";

    public static void d(String mes){
        android.util.Log.d(TAG, mes);
    }
}
