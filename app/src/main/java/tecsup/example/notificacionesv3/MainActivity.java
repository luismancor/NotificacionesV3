package tecsup.example.notificacionesv3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.onesignal.OneSignal;

public class MainActivity extends AppCompatActivity {

    int ID = 1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }



    public void agregarNotificacion(View v){
        Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        //crea bitmap de imagen
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gato);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.perro);
        //imageView.setImageResource(R.drawable.perro);
        //Bitmap bitmap3 = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        //NotificationCompat.BigPictureStyle bigPicture = new NotificationCompat.BigPictureStyle();
        //bigPicture.bigPicture(bitmap2);

        NotificationCompat.Builder builder1 =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.ic_dialog_alert)

                        .setContentTitle("Notificacion")
                        .setSound(alarm)
                        .setContentText("Abrir actividad")

                        .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Esete el mensaje que se muestra cuando se expande la notificacion. Se puede implementar dicha funcionabilidad agregando imagenes, etc."))
                        //.setLargeIcon(bitmap2)
                        //.setStyle(new NotificationCompat.BigPictureStyle()
                                //.bigPicture(bitmap2)
                                //.setSummaryText("noti con imagen")
                                //.bigLargeIcon(null))
                        .setOngoing(true)
                        .setAutoCancel(true)
                        .setNumber(ID);

        Intent notificacionIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificacionIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        builder1.setContentIntent(contentIntent);
        long[] vibraPattern = { 1000, 1000, 1000, 1000,1000,1000 };
        builder1.setVibrate(vibraPattern);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // manager.notify(1,builder1.build());

        manager.notify(ID++,builder1.build());

    }

    //notificacion wiht imagen

    private void bigPictureStyleNotification(View v) {
        int NOTIFICATION_ID = 1;
        Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.perro);

        Intent buttonIntent = new Intent(getBaseContext(), MainActivity.class);
        buttonIntent.putExtra("notificationId", NOTIFICATION_ID);
        PendingIntent dismissIntent = PendingIntent.getBroadcast(getBaseContext(), 0, buttonIntent, 0);
        //PendingIntent launchIntent = getLaunchIntent(NOTIFICATION_ID, getBaseContext());

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.perro);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.perro));
        builder.setContentTitle("Big Picture Style");
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(pic));
        builder.setAutoCancel(true);
        //builder.setContentIntent(launchIntent);
        builder.addAction(android.R.drawable.ic_delete, "DISMISS", dismissIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Will display the notification in the notification bar
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void agregarNotificacion2(View v){

        Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        //crea bitmap de imagen
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.musica);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.perro);

        NotificationCompat.Builder builder1 =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.ic_dialog_alert)
                        .setContentTitle("Notificacion")
                        .setSound(alarm)
                        .setLargeIcon(bitmap2)
                        //.setContentText("Abrir actividad")
                        .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap2)
                        .setSummaryText("notificacion con imagen")
                        .bigLargeIcon(null))
                        //.setOngoing(true)
                        //.setAutoCancel(true)
                        .setNumber(ID);

        Intent notificacionIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificacionIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        builder1.setContentIntent(contentIntent);
        long[] vibraPattern = { 1000, 1000, 1000, 1000,1000,1000 };
        builder1.setVibrate(vibraPattern);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //manager.notify(1,builder1.build());
        manager.notify(ID++,builder1.build());

    }

    public void notificacionImagen (View v){
        Bitmap mybitmap2 =BitmapFactory.decodeResource(getResources(),R.drawable.hurracan);
        Bitmap mybitmap =BitmapFactory.decodeResource(getResources(),R.drawable.fondo4);

        Uri alarm =RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder miBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.perro)
                .setContentTitle("Notificacion con imagen")
                .setSound(alarm)
                .setContentText("Sr. Mancilla")
                .setLargeIcon(mybitmap)
                .setStyle(new NotificationCompat.BigPictureStyle()
                    .bigPicture(mybitmap)
                    .bigLargeIcon(null))
                .setNumber(ID);

        Intent notificacionIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificacionIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        miBuilder.setContentIntent(contentIntent);
        long[] vibraPattern = { 1000, 1000, 1000, 1000,1000,1000 };
        miBuilder.setVibrate(vibraPattern);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //manager.notify(1,miBuilder.build());
        manager.notify(ID++,miBuilder.build());


    }



    //CREA CANAL DE COMUNICACION ENTRE ANDROID Y SO  VERSIONES MAYORES A 2X
    private void crearCanalNotificacion() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(getString(R.string.CHANNEL_ID), name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    // CREA Y CONFIGURA LA NOTIFICACION USANDO EL COMPAT
    public void notificacionOreo(View v){
        crearCanalNotificacion();
        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, getString(R.string.CHANNEL_ID))
                .setSmallIcon(R.drawable.imgnotificacion)
                .setContentTitle("Notificacion Oreo")
                .setContentText("Mi primera notificacion en Oreo")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(ID++, mBuilder.build());
    }



}
