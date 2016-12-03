package ifsp.andressa.calcimposto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalcImposto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_imposto);
    }


    public void btnCalc(View view) {
        double inss = 0;
        double salario_liquido = 0;
        double salario_inss = 0;
        EditText sal_bruto = (EditText)findViewById(R.id.edtSal);
        double salario_bruto = Double.parseDouble(sal_bruto.getText().toString());
        double ir = 0;

        if(salario_bruto <= 1556.94)
        {
            inss = salario_bruto * 0.08;
        }else if(salario_bruto <= 2594.92)
        {
            inss = salario_bruto * 0.09;
        }else if(salario_bruto > 2594.93)
        {
            if(salario_bruto <= 5189.82)
            {
                inss = salario_bruto * 0.11;
            }else
            {
                inss = 5189.82 * 0.11;
            }
        }

        salario_inss = salario_bruto - inss;

        ir = 0;

        if(salario_inss <= 1903.98)
        {
            ir = 0;
        }else if(salario_inss <= 2826.65)
        {
            ir = (salario_inss * 0.075)-142.80;
        }else if(salario_inss <= 3751.05)
        {
            ir = (salario_inss * 0.15)-354.80;
        }else if(salario_inss <= 4664.68)
        {
            ir = (salario_inss * 0.225)-636.13;
        }else if(salario_inss > 4664.68)
        {
            ir = (salario_inss * 0.275)-869.36;
        }

        salario_liquido = (salario_bruto - inss) - ir;

        TextView resultInss = (TextView)(findViewById(R.id.txvINSS));
        TextView resultIr = (TextView)(findViewById(R.id.txvIr));
        TextView resultSalario = (TextView)(findViewById(R.id.txvSalario));

        resultInss.setText(String.format("INSS: %.2f", inss));
        resultIr.setText(String.format("IR: %.2f", ir));
        resultSalario.setText(String.format("Salário Liquido: %.2f", salario_liquido));
    }

    public void btnLimpar(View view) {

        TextView resultInss = (TextView)(findViewById(R.id.txvINSS));
        TextView resultIr = (TextView)(findViewById(R.id.txvIr));
        TextView resultSalario = (TextView)(findViewById(R.id.txvSalario));
        EditText sal_bruto = (EditText)findViewById(R.id.edtSal);

        sal_bruto.setText("");
        resultInss.setText("");
        resultIr.setText("");
        resultSalario.setText("");

    }

}
