package com.example.logonrm.calculator.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.logonrm.calculator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IMCFragment extends Fragment {

    private View view;
    private EditText etAltura;
    private EditText etPeso;
    private RadioGroup rgSexo;
    private TextView tvIMC;
    private ImageView ivIMC;
    private Button btCalcular;

    private double altura;
    private double peso;
    private double imc;

    public IMCFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_imc, container, false);
        etAltura = (EditText) view.findViewById(R.id.etAltura);
        etPeso = (EditText) view.findViewById(R.id.etPeso);
        rgSexo = (RadioGroup) view.findViewById(R.id.rgSexo);
        tvIMC = (TextView) view.findViewById(R.id.tvIMC);
        ivIMC = (ImageView) view.findViewById(R.id.ivIMC);
        btCalcular = (Button) view.findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular(v);
            }
        });

        return view;
    }

    public void calcular(View v) {

        altura = Double.parseDouble(etAltura.getText().toString());
        peso = Double.parseDouble(etPeso.getText().toString());

        imc = peso / (Math.pow(altura, 2));

        if (rgSexo.getCheckedRadioButtonId() == R.id.rbMasculino) {
            if (imc < 20) {
                tvIMC.setText("" + Double.toString(imc) + " - Abaixo");
                ivIMC.setImageResource(R.drawable.abaixo);
            } else if (imc >= 20 && imc < 25) {
                tvIMC.setText("" + Double.toString(imc) + " - Normal");
                ivIMC.setImageResource(R.drawable.normal);
            } else if (imc >= 25 && imc < 30) {
                tvIMC.setText("" + Double.toString(imc) + " - Obesidade Leve");
                ivIMC.setImageResource(R.drawable.obleve);
            } else if (imc >= 30 && imc < 40) {
                tvIMC.setText("" + Double.toString(imc) + " - Obesidade Moderada");
                ivIMC.setImageResource(R.drawable.obmoderada);
            } else {
                tvIMC.setText("" + Double.toString(imc) + " - Obesidade Morbida");
                ivIMC.setImageResource(R.drawable.obmorbida);
            }
        } else {
            if (imc < 19) {
                tvIMC.setText("" + Double.toString(imc) + " - Abaixo");
                ivIMC.setImageResource(R.drawable.abaixo);
            } else if (imc >= 19 && imc < 24) {
                tvIMC.setText("" + Double.toString(imc) + " - Normal");
                ivIMC.setImageResource(R.drawable.normal);
            } else if (imc >= 24 && imc < 29) {
                tvIMC.setText("" + Double.toString(imc) + " - Obesidade Leve");
                ivIMC.setImageResource(R.drawable.obleve);
            } else if (imc >= 29 && imc < 39) {
                tvIMC.setText("" + Double.toString(imc) + " - Obesidade Moderada");
                ivIMC.setImageResource(R.drawable.obmoderada);
            } else {
                tvIMC.setText("" + Double.toString(imc) + " - Obesidade Morbida");
                ivIMC.setImageResource(R.drawable.obmorbida);
            }
        }
    }
}
