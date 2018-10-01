package br.com.buddeis.talkbuddie;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.ServiceCallback;

public class MainActivity extends Activity {

    EditText userInput;
    TextView conversation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conversation = (TextView)findViewById(R.id.conversation);
        userInput = (EditText)findViewById(R.id.user_input);

    }

    public void enviar(View view) {

        final ConversationService myConversationService =
                new ConversationService(
                        "2018-09-20",
                        getString(R.string.username),
                        getString(R.string.password)
                );

        String inputText = userInput.getText().toString();
        conversation.append(
                Html.fromHtml("<p><b>Você:</b> " + inputText + "</p>")
        );

        userInput.setText("");

        MessageRequest request = new MessageRequest.Builder()
                .inputText(inputText)
                .build();

        myConversationService
                .message(getString(R.string.workspace), request)
                .enqueue(new ServiceCallback<MessageResponse>() {
                    @Override
                    public void onResponse(MessageResponse response) {
                        final String outputText = response.getText().get(0);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                conversation.append(
                                        Html.fromHtml("<p><b>Buddies:</b> " +
                                                outputText + "</p>")
                                );
                            }
                        });
                    }

                    @Override
                    public void onFailure(Exception e) {}
                });

    }

}
