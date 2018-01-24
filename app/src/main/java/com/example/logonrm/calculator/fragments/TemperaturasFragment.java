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
public class TemperaturasFragment extends Fragment {

    EditText etTemperatura1;
    EditText etTemperatura2;
    Spinner spTemperaturasDe;
    Spinner spTemperaturasPara;
    boolean converteu = false;

    Double temperatura;

    public TemperaturasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_temperatura, container, false);

        etTemperatura1 = (EditText) view.findViewById(R.id.etTemperatura1);
        etTemperatura2 = (EditText) view.findViewById(R.id.etTemperatura2);
        spTemperaturasDe = (Spinner) view.findViewById(R.id.spTemperaturaDe);
        spTemperaturasPara = (Spinner) view.findViewById(R.id.spTemperaturaPara);

        etTemperatura1.setText("0.0");
        etTemperatura2.setText("0.0");

        etTemperatura1.addTextChangedListener(new TextWatcher() {
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

        etTemperatura2.addTextChangedListener(new TextWatcher() {
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

        spTemperaturasDe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        spTemperaturasPara.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        if (!etTemperatura1.getText().toString().isEmpty()) {
            temperatura = Double.parseDouble(etTemperatura1.getText().toString());

            Double celsius = 0.0;

            if (spTemperaturasDe.getSelectedItem().toString().equals("Grau Celsius")) {
                celsius = temperatura * 1;
            } else if (spTemperaturasDe.getSelectedItem().toString().equals("Grau Fahrenheit")) {
                celsius = ((temperatura - 32)/9) * 5;
            } else if (spTemperaturasDe.getSelectedItem().toString().equals("Kelvin")) {
                celsius = temperatura - 273;
            }

            Double resul = 0.0;

            if (spTemperaturasPara.getSelectedItem().toString().equals("Grau Celsius")) {
                resul = celsius * 1;
            } else if (spTemperaturasPara.getSelectedItem().toString().equals("Grau Fahrenheit")) {
                resul = ((celsius / 5) * 9) + 32;
            } else if (spTemperaturasPara.getSelectedItem().toString().equals("Kelvin")) {
                resul = celsius + 273;
            }

            etTemperatura2.setText(resul.toString());

        } else{
            converteu = false;
        }


    }

    private void converter2() {

        if (!etTemperatura2.getText().toString().isEmpty()) {
            temperatura = Double.parseDouble(etTemperatura2.getText().toString());

            Double celsius = 0.0;

            if (spTemperaturasPara.getSelectedItem().toString().equals("Grau Celsius")) {
                celsius = temperatura * 1;
            } else if (spTemperaturasPara.getSelectedItem().toString().equals("Grau Fahrenheit")) {
                celsius = ((temperatura - 32)/9) * 5;
            } else if (spTemperaturasPara.getSelectedItem().toString().equals("Kelvin")) {
                celsius = temperatura - 273;
            }

            Double resul = 0.0;

            if (spTemperaturasDe.getSelectedItem().toString().equals("Grau Celsius")) {
                resul = celsius * 1;
            } else if (spTemperaturasDe.getSelectedItem().toString().equals("Grau Fahrenheit")) {
                resul = ((celsius / 5) * 9) - 32;
            } else if (spTemperaturasDe.getSelectedItem().toString().equals("Kelvin")) {
                resul = celsius + 273;
            }
            etTemperatura1.setText(resul.toString());

        } else{

            converteu = false;

        }
    }


}
