package com.kokomusoft.panticul.fragments;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.kokomusoft.panticul.R;

import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment implements
        View.OnCreateContextMenuListener, View.OnClickListener {
    private  Session session = null;
    private ProgressDialog progressDialog = null;
    private EditText nameEditText;
    private EditText messageEditText;
    private Spinner subjectSpinner;
    private String personName;
    private String personMessage;
    private String messageSubject;


    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

        nameEditText = (EditText)rootView.findViewById(R.id.nameEditText);
        messageEditText = (EditText)rootView.findViewById(R.id.messageEditText);
        subjectSpinner = (Spinner)rootView.findViewById(R.id.subjectSpinner);


        Button sendButton = (Button)rootView.findViewById(R.id.sendButton);
        sendButton.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {

        if (isNetworkAvailable()){
            personName = nameEditText.getText().toString();
            personMessage = messageEditText.getText().toString();
            messageSubject = subjectSpinner.getSelectedItem().toString();

            if (validFields()){

                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class",
                        "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtps.auth", "true");
                properties.put("mail.smtp.port", "465");

                session = Session.getInstance(properties, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("fridafoe@gmail.com",
                                "focaloca");
                    }
                });
                session.setDebug(true);

                progressDialog = ProgressDialog.show(this.getActivity().getWindow().
                                getContext(),
                        "Hecho", "Enviando el Mensaje...", true);

                RetreiveFeedTask task = new RetreiveFeedTask();
                task.execute();


            }

        }else{
            progressDialog = ProgressDialog.show(this.getActivity().getWindow()
                            .getContext(),
                    "Lo sentimos", "Parece que no hay una conexión a internet.",
                    true);

            final Timer t = new Timer();
            t.schedule(new TimerTask() {
                public void run() {
                    progressDialog.dismiss(); // when the task active then close the dialog
                    t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                }
            }, 3000); // after 2 second (or 2000 miliseconds), the task will be active
        }


    }

    private boolean validFields() {
        if (personName.length() == 0){
            nameEditText.setError("Por favor complete este campo");
            return false;
        }

        if (personMessage.length() == 0){
            messageEditText.setError("Por favor complete este campo");
            return false;
        }
        return true;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)getActivity().
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;

        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }

        return isAvailable;
    }

    class RetreiveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String completeMessage = "Mensaje enviado por: " + personName + "\n" +
                    ". Tipo de mensaje :" + messageSubject + "\n" + ". El mensaje es :"
                    + personMessage;

            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("testfrom354@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.
                        parse("gabrieldzul@gmail.com"));
                message.setSubject(messageSubject);
                message.setSentDate(new Date());
                message.setContent(completeMessage, "text/html; charset=utf-8");
                Transport.send(message);
            } catch(MessagingException e) {
                e.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
          progressDialog.dismiss();
            messageEditText.setText("");
            Toast.makeText(getActivity().getApplicationContext(),
                    "El mensaje ha sido Envíado", Toast.LENGTH_LONG).show();
        }
    }

}
