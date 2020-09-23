package com.android.mario.yamb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText D1, D2, D3, D4, D5, D6, S1, S2, S3, S4, S5, S6, G1, G2, G3, G4, G5, G6,
            N1, N2, N3, N4, N5, N6, PN1, PN2, PN3, PN4, PN5, PN6, MxD, MiD, SkD, FuD, PoD, YaD,
            MxG, MiG, SkG, FuG, PoG, YaG, MxS, MiS, SkS, FuS, PoS, YaS, MxN, MiN, SkN, FuN, PoN,
            YaN, MxPN, MiPN, SkPN, FuPN, PoPN, YaPN, sumBrD, sumBrG, sumBrS, sumBrN, sumBrPN, sumRD,
            sumRS, sumRG, sumRN, sumRPN, sumSD, sumSS, sumSG, sumSN, sumSPN, sumT1, sumT2, sumT3, sumT;
    TableLayout tableSum;
    int resBrD, resBrS, resBrG, resBrN, resBrPN, resRD, resRS, resRG, resRN, resRPN, resSD, resSS,
            resSG, resSN, resSPN, totB, totR, totS, total;
    int showText = -16777216; //default color
    int hideText = -1973791; //color #e1e1e1
    int hideTotal = -1; //color #ffffff

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.hide_totals) {
            EditText tot1 = findViewById(R.id.sumT_1);
            tot1.setTextColor(hideText);
            EditText tot2 = findViewById(R.id.sumT_R);
            tot2.setTextColor(hideText);
            EditText tot3 = findViewById(R.id.sumSS_R);
            tot3.setTextColor(hideText);
            EditText tot4 = findViewById(R.id.total);
            tot4.setTextColor(hideTotal);
            return true;
        }
        if (id == R.id.show_totals) {
            EditText tot1 = findViewById(R.id.sumT_1);
            tot1.setTextColor(showText);
            EditText tot2 = findViewById(R.id.sumT_R);
            tot2.setTextColor(showText);
            EditText tot3 = findViewById(R.id.sumSS_R);
            tot3.setTextColor(showText);
            EditText tot4 = findViewById(R.id.total);
            tot4.setTextColor(showText);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById(R.id.Table1).setOnTouchListener(this);

        D1 = (EditText)findViewById(R.id.down_1);
        D2 = (EditText)findViewById(R.id.down_2);
        D3 = (EditText)findViewById(R.id.down_3);
        D4 = (EditText)findViewById(R.id.down_4);
        D5 = (EditText)findViewById(R.id.down_5);
        D6 = (EditText)findViewById(R.id.down_6);
        S1 = (EditText)findViewById(R.id.free_1);
        S2 = (EditText)findViewById(R.id.free_2);
        S3 = (EditText)findViewById(R.id.free_3);
        S4 = (EditText)findViewById(R.id.free_4);
        S5 = (EditText)findViewById(R.id.free_5);
        S6 = (EditText)findViewById(R.id.free_6);
        G1 = (EditText)findViewById(R.id.up_1);
        G2 = (EditText)findViewById(R.id.up_2);
        G3 = (EditText)findViewById(R.id.up_3);
        G4 = (EditText)findViewById(R.id.up_4);
        G5 = (EditText)findViewById(R.id.up_5);
        G6 = (EditText)findViewById(R.id.up_6);
        N1 = (EditText)findViewById(R.id.naj_1);
        N2 = (EditText)findViewById(R.id.naj_2);
        N3 = (EditText)findViewById(R.id.naj_3);
        N4 = (EditText)findViewById(R.id.naj_4);
        N5 = (EditText)findViewById(R.id.naj_5);
        N6 = (EditText)findViewById(R.id.naj_6);
        PN1 = (EditText)findViewById(R.id.pnaj_1);
        PN2 = (EditText)findViewById(R.id.pnaj_2);
        PN3 = (EditText)findViewById(R.id.pnaj_3);
        PN4 = (EditText)findViewById(R.id.pnaj_4);
        PN5 = (EditText)findViewById(R.id.pnaj_5);
        PN6 = (EditText)findViewById(R.id.pnaj_6);
        MxD = (EditText)findViewById(R.id.max_D);
        MiD = (EditText)findViewById(R.id.min_D);
        SkD = (EditText)findViewById(R.id.skala_D);
        FuD = (EditText)findViewById(R.id.ful_D);
        PoD = (EditText)findViewById(R.id.poker_D);
        YaD = (EditText)findViewById(R.id.yamb_D);
        MxS = (EditText)findViewById(R.id.max_S);
        MiS = (EditText)findViewById(R.id.min_S);
        SkS = (EditText)findViewById(R.id.skala_S);
        FuS = (EditText)findViewById(R.id.ful_S);
        PoS = (EditText)findViewById(R.id.poker_S);
        YaS = (EditText)findViewById(R.id.yamb_S);
        MxG = (EditText)findViewById(R.id.max_G);
        MiG = (EditText)findViewById(R.id.min_G);
        SkG = (EditText)findViewById(R.id.skala_G);
        FuG = (EditText)findViewById(R.id.ful_G);
        PoG = (EditText)findViewById(R.id.poker_G);
        YaG = (EditText)findViewById(R.id.yamb_G);
        MxN = (EditText)findViewById(R.id.max_N);
        MiN = (EditText)findViewById(R.id.min_N);
        SkN = (EditText)findViewById(R.id.skala_N);
        FuN = (EditText)findViewById(R.id.ful_N);
        PoN = (EditText)findViewById(R.id.poker_N);
        YaN = (EditText)findViewById(R.id.yamb_N);
        MxPN = (EditText)findViewById(R.id.max_PN);
        MiPN = (EditText)findViewById(R.id.min_PN);
        SkPN = (EditText)findViewById(R.id.skala_PN);
        FuPN = (EditText)findViewById(R.id.ful_PN);
        PoPN = (EditText)findViewById(R.id.poker_PN);
        YaPN = (EditText)findViewById(R.id.yamb_PN);

        sumBrD = (EditText) findViewById(R.id.sumD_1);
        sumBrS = (EditText) findViewById(R.id.sumS_1);
        sumBrG = (EditText) findViewById(R.id.sumG_1);
        sumBrN = (EditText) findViewById(R.id.sumN_1);
        sumBrPN = (EditText) findViewById(R.id.sumPN_1);
        sumRD = (EditText) findViewById(R.id.sumR_D);
        sumRS = (EditText) findViewById(R.id.sumR_S);
        sumRG = (EditText) findViewById(R.id.sumR_G);
        sumRN = (EditText) findViewById(R.id.sumR_N);
        sumRPN = (EditText) findViewById(R.id.sumR_PN);
        sumSD = (EditText) findViewById(R.id.sumSS_D);
        sumSS = (EditText) findViewById(R.id.sumSS_S);
        sumSG = (EditText) findViewById(R.id.sumSS_G);
        sumSN = (EditText) findViewById(R.id.sumSS_N);
        sumSPN = (EditText) findViewById(R.id.sumSS_PN);

        sumT1 = (EditText) findViewById(R.id.sumT_1);
        sumT2 = (EditText) findViewById(R.id.sumT_R);
        sumT3 = (EditText) findViewById(R.id.sumSS_R);
        sumT = (EditText) findViewById(R.id.total);

        tableSum = (TableLayout)findViewById(R.id.Table1);

        TextWatcher watch = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int iD1 = 0;
                int iD2 = 0;
                int iD3 = 0;
                int iD4 = 0;
                int iD5 = 0;
                int iD6 = 0;
                int iS1 = 0;
                int iS2 = 0;
                int iS3 = 0;
                int iS4 = 0;
                int iS5 = 0;
                int iS6 = 0;
                int iG1 = 0;
                int iG2 = 0;
                int iG3 = 0;
                int iG4 = 0;
                int iG5 = 0;
                int iG6 = 0;
                int iN1 = 0;
                int iN2 = 0;
                int iN3 = 0;
                int iN4 = 0;
                int iN5 = 0;
                int iN6 = 0;
                int iPN1 = 0;
                int iPN2 = 0;
                int iPN3 = 0;
                int iPN4 = 0;
                int iPN5 = 0;
                int iPN6 = 0;
                int iMxD = 0;
                int iMnD = 0;
                int iMxS = 0;
                int iMnS = 0;
                int iMxG = 0;
                int iMnG = 0;
                int iMxN = 0;
                int iMnN = 0;
                int iMxPN = 0;
                int iMnPN = 0;
                int iSkD = 0;
                int iSkS = 0;
                int iSkG = 0;
                int iSkN = 0;
                int iSkPN = 0;
                int iFuD = 0;
                int iFuS = 0;
                int iFuG = 0;
                int iFuN = 0;
                int iFuPN = 0;
                int iPoD = 0;
                int iPoS = 0;
                int iPoG = 0;
                int iPoN = 0;
                int iPoPN = 0;
                int iYaD = 0;
                int iYaS = 0;
                int iYaG = 0;
                int iYaN = 0;
                int iYaPN = 0;

                if (!D1.getText().toString().isEmpty()) iD1 = Integer.parseInt(D1.getText().toString());
                if (!D2.getText().toString().isEmpty()) iD2 = Integer.parseInt(D2.getText().toString());
                if (!D3.getText().toString().isEmpty()) iD3 = Integer.parseInt(D3.getText().toString());
                if (!D4.getText().toString().isEmpty()) iD4 = Integer.parseInt(D4.getText().toString());
                if (!D5.getText().toString().isEmpty()) iD5 = Integer.parseInt(D5.getText().toString());
                if (!D6.getText().toString().isEmpty()) iD6 = Integer.parseInt(D6.getText().toString());
                if (!S1.getText().toString().isEmpty()) iS1 = Integer.parseInt(S1.getText().toString());
                if (!S2.getText().toString().isEmpty()) iS2 = Integer.parseInt(S2.getText().toString());
                if (!S3.getText().toString().isEmpty()) iS3 = Integer.parseInt(S3.getText().toString());
                if (!S4.getText().toString().isEmpty()) iS4 = Integer.parseInt(S4.getText().toString());
                if (!S5.getText().toString().isEmpty()) iS5 = Integer.parseInt(S5.getText().toString());
                if (!S6.getText().toString().isEmpty()) iS6 = Integer.parseInt(S6.getText().toString());
                if (!G1.getText().toString().isEmpty()) iG1 = Integer.parseInt(G1.getText().toString());
                if (!G2.getText().toString().isEmpty()) iG2 = Integer.parseInt(G2.getText().toString());
                if (!G3.getText().toString().isEmpty()) iG3 = Integer.parseInt(G3.getText().toString());
                if (!G4.getText().toString().isEmpty()) iG4 = Integer.parseInt(G4.getText().toString());
                if (!G5.getText().toString().isEmpty()) iG5 = Integer.parseInt(G5.getText().toString());
                if (!G6.getText().toString().isEmpty()) iG6 = Integer.parseInt(G6.getText().toString());
                if (!N1.getText().toString().isEmpty()) iN1 = Integer.parseInt(N1.getText().toString());
                if (!N2.getText().toString().isEmpty()) iN2 = Integer.parseInt(N2.getText().toString());
                if (!N3.getText().toString().isEmpty()) iN3 = Integer.parseInt(N3.getText().toString());
                if (!N4.getText().toString().isEmpty()) iN4 = Integer.parseInt(N4.getText().toString());
                if (!N5.getText().toString().isEmpty()) iN5 = Integer.parseInt(N5.getText().toString());
                if (!N6.getText().toString().isEmpty()) iN6 = Integer.parseInt(N6.getText().toString());
                if (!PN1.getText().toString().isEmpty()) iPN1 = Integer.parseInt(PN1.getText().toString());
                if (!PN2.getText().toString().isEmpty()) iPN2 = Integer.parseInt(PN2.getText().toString());
                if (!PN3.getText().toString().isEmpty()) iPN3 = Integer.parseInt(PN3.getText().toString());
                if (!PN4.getText().toString().isEmpty()) iPN4 = Integer.parseInt(PN4.getText().toString());
                if (!PN5.getText().toString().isEmpty()) iPN5 = Integer.parseInt(PN5.getText().toString());
                if (!PN6.getText().toString().isEmpty()) iPN6 = Integer.parseInt(PN6.getText().toString());
                if (!MxD.getText().toString().isEmpty()) iMxD = Integer.parseInt(MxD.getText().toString());
                if (!MiD.getText().toString().isEmpty()) iMnD = Integer.parseInt(MiD.getText().toString());
                if (!MxS.getText().toString().isEmpty()) iMxS = Integer.parseInt(MxS.getText().toString());
                if (!MiS.getText().toString().isEmpty()) iMnS = Integer.parseInt(MiS.getText().toString());
                if (!MxG.getText().toString().isEmpty()) iMxG = Integer.parseInt(MxG.getText().toString());
                if (!MiG.getText().toString().isEmpty()) iMnG = Integer.parseInt(MiG.getText().toString());
                if (!MxN.getText().toString().isEmpty()) iMxN = Integer.parseInt(MxN.getText().toString());
                if (!MiN.getText().toString().isEmpty()) iMnN = Integer.parseInt(MiN.getText().toString());
                if (!MxPN.getText().toString().isEmpty()) iMxPN = Integer.parseInt(MxPN.getText().toString());
                if (!MiPN.getText().toString().isEmpty()) iMnPN = Integer.parseInt(MiPN.getText().toString());
                if (!SkD.getText().toString().isEmpty()) iSkD = Integer.parseInt(SkD.getText().toString());
                if (!FuD.getText().toString().isEmpty()) iFuD = Integer.parseInt(FuD.getText().toString());
                if (!PoD.getText().toString().isEmpty()) iPoD = Integer.parseInt(PoD.getText().toString());
                if (!YaD.getText().toString().isEmpty()) iYaD = Integer.parseInt(YaD.getText().toString());
                if (!SkS.getText().toString().isEmpty()) iSkS = Integer.parseInt(SkS.getText().toString());
                if (!FuS.getText().toString().isEmpty()) iFuS = Integer.parseInt(FuS.getText().toString());
                if (!PoS.getText().toString().isEmpty()) iPoS = Integer.parseInt(PoS.getText().toString());
                if (!YaS.getText().toString().isEmpty()) iYaS = Integer.parseInt(YaS.getText().toString());
                if (!SkG.getText().toString().isEmpty()) iSkG = Integer.parseInt(SkG.getText().toString());
                if (!FuG.getText().toString().isEmpty()) iFuG = Integer.parseInt(FuG.getText().toString());
                if (!PoG.getText().toString().isEmpty()) iPoG = Integer.parseInt(PoG.getText().toString());
                if (!YaG.getText().toString().isEmpty()) iYaG = Integer.parseInt(YaG.getText().toString());
                if (!SkN.getText().toString().isEmpty()) iSkN = Integer.parseInt(SkN.getText().toString());
                if (!FuN.getText().toString().isEmpty()) iFuN = Integer.parseInt(FuN.getText().toString());
                if (!PoN.getText().toString().isEmpty()) iPoN = Integer.parseInt(PoN.getText().toString());
                if (!YaN.getText().toString().isEmpty()) iYaN = Integer.parseInt(YaN.getText().toString());
                if (!SkPN.getText().toString().isEmpty()) iSkPN = Integer.parseInt(SkPN.getText().toString());
                if (!FuPN.getText().toString().isEmpty()) iFuPN = Integer.parseInt(FuPN.getText().toString());
                if (!PoPN.getText().toString().isEmpty()) iPoPN = Integer.parseInt(PoPN.getText().toString());
                if (!YaPN.getText().toString().isEmpty()) iYaPN = Integer.parseInt(YaPN.getText().toString());

                resBrD = iD1 + iD2 + iD3 + iD4 + iD5 + iD6;
                if (resBrD >= 60 && resBrD < 70) resBrD = resBrD + 30;
                else if (resBrD >= 70 && resBrD < 80) resBrD += 40;
                else if (resBrD >= 80 && resBrD < 90) resBrD += 50;
                else if (resBrD >= 90 && resBrD < 100) resBrD += 60;
                else if (resBrD >= 100) resBrD += 70;

                resBrS = iS1 + iS2 + iS3 + iS4 + iS5 + iS6;
                if (resBrS >= 60 && resBrS < 70) resBrS += 30;
                else if (resBrS >= 70 && resBrS < 80) resBrS += 40;
                else if (resBrS >= 80 && resBrS < 90) resBrS += 50;
                else if (resBrS >= 90 && resBrS < 100) resBrS += 60;
                else if (resBrS >= 100) resBrS += 70;

                resBrG = iG1 + iG2 + iG3 + iG4 + iG5 + iG6;
                if (resBrG >= 60 && resBrG < 70) resBrG += 30;
                else if (resBrG >= 70 && resBrG < 80) resBrG += 40;
                else if (resBrG >= 80 && resBrG < 90) resBrG += 50;
                else if (resBrG >= 90 && resBrG < 100) resBrG += 60;
                else if (resBrG >= 100) resBrG += 70;

                resBrN = iN1 + iN2 + iN3 + iN4 + iN5 + iN6;
                if (resBrN >= 60 && resBrN < 70) resBrN += 30;
                else if (resBrN >= 70 && resBrN < 80) resBrN += 40;
                else if (resBrN >= 80 && resBrN < 90) resBrN += 50;
                else if (resBrN >= 90 && resBrN < 100) resBrN += 60;
                else if (resBrN >= 100) resBrN += 70;

                resBrPN = iPN1 + iPN2 + iPN3 + iPN4 + iPN5 + iPN6;
                if (resBrPN >= 60 && resBrPN < 70) resBrPN += 30;
                else if (resBrPN >= 70 && resBrPN < 80) resBrPN += 40;
                else if (resBrPN >= 80 && resBrPN < 90) resBrPN += 50;
                else if (resBrPN >= 90 && resBrPN < 100) resBrPN += 60;
                else if (resBrPN >= 100) resBrPN += 70;

                sumBrD.setText(String.valueOf(resBrD));
                sumBrS.setText(String.valueOf(resBrS));
                sumBrG.setText(String.valueOf(resBrG));
                sumBrN.setText(String.valueOf(resBrN));
                sumBrPN.setText(String.valueOf(resBrPN));

                totB = resBrD + resBrS + resBrG + resBrN + resBrPN;
                sumT1.setText(String.valueOf(totB));

                if (iMxD >= iMnD && iMnD > 0) resRD = (iMxD - iMnD) * iD1;
                else resRD = 0;
                if (resRD >= 60) resRD += 30;

                if (iMxS >= iMnS && iMnS > 0) resRS = (iMxS - iMnS)*iS1;
                else resRS = 0;
                if (resRS >=60) resRS += 30;

                if (iMxG >= iMnG && iMnG > 0) resRG = (iMxG - iMnG)*iG1;
                else resRG = 0;
                if (resRG >= 60) resRG += 30;

                if (iMxN >= iMnN && iMnN > 0) resRN = (iMxN - iMnN)*iN1;
                else resRN = 0;
                if (resRN >= 60) resRN += 30;

                if (iMxPN >= iMnPN && iMnPN > 0) resRPN = (iMxPN - iMnPN)*iPN1;
                else resRPN = 0;
                if (resRPN >=60) resRPN += 30;

                sumRD.setText(String.valueOf(resRD));
                sumRS.setText(String.valueOf(resRS));
                sumRG.setText(String.valueOf(resRG));
                sumRN.setText(String.valueOf(resRN));
                sumRPN.setText(String.valueOf(resRPN));

                totR = resRD + resRS + resRG + resRN + resRPN;
                sumT2.setText(String.valueOf(totR));
                Log.i("mmii value T4: ", String.valueOf(sumT.getCurrentTextColor()));

                resSD = iSkD + iFuD + iPoD + iYaD;
                resSS = iSkS + iFuS + iPoS + iYaS;
                resSG = iSkG + iFuG + iPoG + iYaG;
                resSN = iSkN + iFuN + iPoN + iYaN;
                resSPN = iSkPN + iFuPN + iPoPN + iYaPN;

                sumSD.setText(String.valueOf(resSD));
                sumSS.setText(String.valueOf(resSS));
                sumSG.setText(String.valueOf(resSG));
                sumSN.setText(String.valueOf(resSN));
                sumSPN.setText(String.valueOf(resSPN));

                totS = resSD + resSS + resSG + resSN + resSPN;
                sumT3.setText(String.valueOf(totS));

                total = totB + totR + totS;
                sumT.setText(String.valueOf(total));

            }
        };

        D1.addTextChangedListener(watch);
        D2.addTextChangedListener(watch);
        D3.addTextChangedListener(watch);
        D4.addTextChangedListener(watch);
        D5.addTextChangedListener(watch);
        D6.addTextChangedListener(watch);
        S1.addTextChangedListener(watch);
        S2.addTextChangedListener(watch);
        S3.addTextChangedListener(watch);
        S4.addTextChangedListener(watch);
        S5.addTextChangedListener(watch);
        S6.addTextChangedListener(watch);
        G1.addTextChangedListener(watch);
        G2.addTextChangedListener(watch);
        G3.addTextChangedListener(watch);
        G4.addTextChangedListener(watch);
        G5.addTextChangedListener(watch);
        G6.addTextChangedListener(watch);
        N1.addTextChangedListener(watch);
        N2.addTextChangedListener(watch);
        N3.addTextChangedListener(watch);
        N4.addTextChangedListener(watch);
        N5.addTextChangedListener(watch);
        N6.addTextChangedListener(watch);
        PN1.addTextChangedListener(watch);
        PN2.addTextChangedListener(watch);
        PN3.addTextChangedListener(watch);
        PN4.addTextChangedListener(watch);
        PN5.addTextChangedListener(watch);
        PN6.addTextChangedListener(watch);
        MiD.addTextChangedListener(watch);
        MiS.addTextChangedListener(watch);
        MiG.addTextChangedListener(watch);
        MiN.addTextChangedListener(watch);
        MiPN.addTextChangedListener(watch);
        MxD.addTextChangedListener(watch);
        MxS.addTextChangedListener(watch);
        MxG.addTextChangedListener(watch);
        MxN.addTextChangedListener(watch);
        MxPN.addTextChangedListener(watch);
        SkD.addTextChangedListener(watch);
        SkS.addTextChangedListener(watch);
        SkG.addTextChangedListener(watch);
        SkN.addTextChangedListener(watch);
        SkPN.addTextChangedListener(watch);
        FuD.addTextChangedListener(watch);
        FuS.addTextChangedListener(watch);
        FuG.addTextChangedListener(watch);
        FuN.addTextChangedListener(watch);
        FuPN.addTextChangedListener(watch);
        PoD.addTextChangedListener(watch);
        PoS.addTextChangedListener(watch);
        PoG.addTextChangedListener(watch);
        PoN.addTextChangedListener(watch);
        PoPN.addTextChangedListener(watch);
        YaD.addTextChangedListener(watch);
        YaS.addTextChangedListener(watch);
        YaG.addTextChangedListener(watch);
        YaN.addTextChangedListener(watch);
        YaPN.addTextChangedListener(watch);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to Exit? You will lose all your results!")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        //super.onBackPressed();
    }
}
