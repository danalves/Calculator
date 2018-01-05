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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalcFragment extends Fragment {

    private TextView tvCalc0, tvCalc1, tvCalc2, tvCalc3, tvCalc4, tvCalc5, tvCalc6, tvCalc7, tvCalc8,
            tvCalc9, tvCalcAdi, tvCalcSub, tvCalcDiv, tvCalcMult, tvCalcApagar, tvCalcIgual, tvCalcPonto,
            tvCalcResultado;

    private String display;
    private String valorString;

    private List<String> valores;
    private Double valor1;
    private Double valor2;
    private Double resultado;
    private int i;

    public CalcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calc, container, false);
        tvCalc0 = (TextView) view.findViewById(R.id.tvCalc0);
        tvCalc1 = (TextView) view.findViewById(R.id.tvCalc1);
        tvCalc2 = (TextView) view.findViewById(R.id.tvCalc2);
        tvCalc3 = (TextView) view.findViewById(R.id.tvCalc3);
        tvCalc4 = (TextView) view.findViewById(R.id.tvCalc4);
        tvCalc5 = (TextView) view.findViewById(R.id.tvCalc5);
        tvCalc6 = (TextView) view.findViewById(R.id.tvCalc6);
        tvCalc7 = (TextView) view.findViewById(R.id.tvCalc7);
        tvCalc8 = (TextView) view.findViewById(R.id.tvCalc8);
        tvCalc9 = (TextView) view.findViewById(R.id.tvCalc9);
        tvCalcAdi = (TextView) view.findViewById(R.id.tvCalcAdi);
        tvCalcSub = (TextView) view.findViewById(R.id.tvCalcSub);
        tvCalcDiv = (TextView) view.findViewById(R.id.tvCalcDiv);
        tvCalcMult = (TextView) view.findViewById(R.id.tvCalcMult);
        tvCalcApagar = (TextView) view.findViewById(R.id.tvCalcApagar);
        tvCalcIgual = (TextView) view.findViewById(R.id.tvCalcIgual);
        tvCalcPonto = (TextView) view.findViewById(R.id.tvCalcPonto);
        tvCalcResultado = (TextView) view.findViewById(R.id.tvCalcResultado);

        configurarOnClickListener(tvCalc0);
        configurarOnClickListener(tvCalc1);
        configurarOnClickListener(tvCalc2);
        configurarOnClickListener(tvCalc3);
        configurarOnClickListener(tvCalc4);
        configurarOnClickListener(tvCalc5);
        configurarOnClickListener(tvCalc6);
        configurarOnClickListener(tvCalc7);
        configurarOnClickListener(tvCalc8);
        configurarOnClickListener(tvCalc9);
        configurarOnClickListener(tvCalcAdi);
        configurarOnClickListener(tvCalcSub);
        configurarOnClickListener(tvCalcDiv);
        configurarOnClickListener(tvCalcMult);
        configurarOnClickListener(tvCalcApagar);
        configurarOnClickListener(tvCalcIgual);
        configurarOnClickListener(tvCalcPonto);

        display = "";
        valorString = "";
        valores = new ArrayList<>();
        i = 0;

        return view;
    }

    public void configurarOnClickListener(View v) {

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teclar((TextView) v);
            }
        });
    }

    public void teclar(TextView botao) {

        switch (botao.getId()) {
            case R.id.tvCalc0:
                valorString = valorString + "0";
                display = display + "0";
                tvCalcResultado.setText(display);

                break;
            case R.id.tvCalc1:
                valorString = valorString + "1";
                display = display + "1";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalc2:
                valorString = valorString + "2";
                display = display + "2";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalc3:
                valorString = valorString + "3";
                display = display + "3";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalc4:
                valorString = valorString + "4";
                display = display + "4";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalc5:
                valorString = valorString + "5";
                display = display + "5";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalc6:
                valorString = valorString + "6";
                display = display + "6";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalc7:
                valorString = valorString + "7";
                display = display + "7";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalc8:
                valorString = valorString + "8";
                display = display + "8";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalc9:
                valorString = valorString + "9";
                display = display + "9";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalcAdi:
                valores.add(valorString);
                valores.add("+");
                valorString = "";
                display = display + "+";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalcSub:
                valores.add(valorString);
                valores.add("-");
                valorString = "";
                display = display + "-";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalcDiv:
                valores.add(valorString);
                valores.add("÷");
                valorString = "";
                display = display + "÷";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalcMult:
                valores.add(valorString);
                valores.add("x");
                valorString = "";
                display = display + "x";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalcApagar:
                valores.clear();
                valorString = "";
                display = "";
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalcIgual:
                valores.add(valorString);
                valorString = "";
                calcular();
                display = valores.get(0);
                tvCalcResultado.setText(display);
                break;
            case R.id.tvCalcPonto:
                valorString = valorString + ".";
                display = display + ".";
                tvCalcResultado.setText(display);
                break;

        }
    }

    private void calcular() {

        boolean encontrou = true;

        while (encontrou && valores.size() > 1) {
            encontrou = false;
            for (int i = 0; i < valores.size() - 1; i++) {
                if (valores.get(i) == "÷" || valores.get(i) == "x") {
                    valor1 = Double.parseDouble(valores.get(i - 1));
                    valor2 = Double.parseDouble(valores.get(i + 1));
                    if (valores.get(i) == "÷") {
                        resultado = valor1 / valor2;
                    } else {
                        resultado = valor1 * valor2;
                    }
                    valores.set(i - 1, resultado.toString());
                    valores.remove(i + 1);
                    valores.remove(i);
                    encontrou = true;
                    break;
                }
            }
        }

        encontrou = true;

        while (encontrou && valores.size() > 1) {
            encontrou = false;
            for (int i = 0; i < valores.size() - 1; i++) {
                if (valores.get(i) == "+" || valores.get(i) == "-") {
                    valor1 = Double.parseDouble(valores.get(i - 1));
                    valor2 = Double.parseDouble(valores.get(i + 1));
                    if (valores.get(i) == "+") {
                        resultado = valor1 + valor2;
                    } else {
                        resultado = valor1 - valor2;
                    }
                    valores.set(i - 1, resultado.toString());
                    valores.remove(i + 1);
                    valores.remove(i);
                    encontrou = true;
                    break;
                }
            }
        }
    }

}
