package com.example.logonrm.calculator.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.logonrm.calculator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedidasFragment extends Fragment {

    EditText etMedida1;
    EditText etMedida2;
    Spinner spMedidasDe;
    Spinner spMedidasPara;
    boolean converteu = false;

    Double medida;

    public MedidasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medidas, container, false);

        etMedida1 = (EditText) view.findViewById(R.id.etMedidas1);
        etMedida2 = (EditText) view.findViewById(R.id.etMedidas2);
        spMedidasDe = (Spinner) view.findViewById(R.id.spMedidasDe);
        spMedidasPara = (Spinner) view.findViewById(R.id.spMedidasPara);

        etMedida1.setText("0.0");
        etMedida2.setText("0.0");

        etMedida1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (converteu) {
                    converteu = false;
                } else {
                    converteu = true;
                    converter1();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etMedida2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (converteu) {
                    converteu = false;
                } else {
                    converteu = true;
                    converter2();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        spMedidasDe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (converteu) {
                    converteu = false;
                } else {
                    converteu = true;
                    converter2();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spMedidasPara.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (converteu) {
                    converteu = false;
                } else {
                    converteu = true;
                    converter1();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    private void converter1() {

        if (!etMedida1.getText().toString().isEmpty()) {
            medida = Double.parseDouble(etMedida1.getText().toString());

            Double metro = 0.0;

            if (spMedidasDe.getSelectedItem().toString().equals("Quilômetro")) {
                metro = medida * 1000;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Metro")) {
                metro = medida * 1;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Centímetro")) {
                metro = medida * 0.01;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Milímetro")) {
                metro = medida * 0.001;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Milha")) {
                metro = medida * 1609.34;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Jarda")) {
                metro = medida * 0.9144;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Pé")) {
                metro = medida * 0.3048;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Polegada")) {
                metro = medida * 0.0254;
            }

            Double resul = 0.0;

            if (spMedidasPara.getSelectedItem().toString().equals("Quilômetro")) {
                resul = metro * 0.001;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Metro")) {
                resul = metro * 1;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Centímetro")) {
                resul = metro * 100;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Milímetro")) {
                resul = metro * 1000;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Milha")) {
                resul = metro * 0.000621371;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Jarda")) {
                resul = metro * 1.09361;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Pé")) {
                resul = metro * 3.28084;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Polegada")) {
                resul = metro * 39.3701;
            }

            etMedida2.setText(resul.toString());

        } else{
            converteu = false;
        }


    }

    private void converter2() {

        if (!etMedida2.getText().toString().isEmpty()) {
            medida = Double.parseDouble(etMedida2.getText().toString());

            Double metro = 0.0;

            if (spMedidasPara.getSelectedItem().toString().equals("Quilômetro")) {
                metro = medida * 1000;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Metro")) {
                metro = medida * 1;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Centímetro")) {
                metro = medida * 0.01;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Milímetro")) {
                metro = medida * 0.001;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Milha")) {
                metro = medida * 1609.34;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Jarda")) {
                metro = medida * 0.9144;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Pé")) {
                metro = medida * 0.3048;
            } else if (spMedidasPara.getSelectedItem().toString().equals("Polegada")) {
                metro = medida * 0.0254;
            }

            Double resul = 0.0;

            if (spMedidasDe.getSelectedItem().toString().equals("Quilômetro")) {
                resul = metro * 0.001;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Metro")) {
                resul = metro * 1;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Centímetro")) {
                resul = metro * 100;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Milímetro")) {
                resul = metro * 1000;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Milha")) {
                resul = metro * 0.000621371;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Jarda")) {
                resul = metro * 1.09361;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Pé")) {
                resul = metro * 3.28084;
            } else if (spMedidasDe.getSelectedItem().toString().equals("Polegada")) {
                resul = metro * 39.3701;
            }

            etMedida1.setText(resul.toString());

        } else{

            converteu = false;

        }
    }


}
