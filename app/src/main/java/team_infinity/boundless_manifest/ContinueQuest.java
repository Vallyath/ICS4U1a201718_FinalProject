package team_infinity.boundless_manifest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import javax.microedition.khronos.opengles.GL;

/**
 * Created by Vallyath on 2017-12-21.
 */

public class ContinueQuest extends android.support.v4.app.DialogFragment {

    public Dialog onCreateDialog (Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        //looks at which layout to get data from
        View dialogView = inflater.inflate(R.layout.continuequest, null);

        //finds the buttons in the layout
        Button newGameBtn = (Button) dialogView.findViewById(R.id.NewGame);
        Button exitBtn = (Button) dialogView.findViewById(R.id.Exit);
        TextView continueQuestion = (TextView) dialogView.findViewById(R.id.Question);

        // sets what would happen if newGameBtn was pressed
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //request a session id from server and plug it into the global variable
                QuestStartRequest qsr = new QuestStartRequest();
                GlobalAttributes.currentSessionId = qsr.startRequest(GlobalAttributes.currentSelectedSubject);

                Log.d("qst", "ContinueQuest.onCreateDialog(): currentSessionId: " + GlobalAttributes.currentSessionId);
                //if pressed, intent makes it jump to the question activity class
                Intent playGame = new Intent(view.getContext(), QuestionActivity.class);
                startActivity(playGame);
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        //sets the text to buttons
        //continueBtn.setText("Continue Game");
        newGameBtn.setText("New Game");
        exitBtn.setText("Exit");
        exitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dismiss();
            }
        });

        builder.setView(dialogView).setMessage("");
        return builder.create();
    }

    /**
     * if view is not null, then display this pop-up, otherwise inflate it
     * @param view
     * @param viewGroup
     * @return View
     */
    public View getView(View view, ViewGroup viewGroup){

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.continuequest, viewGroup, false);
        }

        return view;
    }
}
