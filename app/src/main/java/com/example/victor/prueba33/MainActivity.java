package com.example.victor.prueba33;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int num = 0;
    String number = "";
    TextView texto, aleator;
    EditText campo_texto;
    Button boton, boton2;
    int aleatorio=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aleator=(TextView) findViewById(R.id.etiqueta2);
        texto = (TextView) findViewById(R.id.texto);
        campo_texto= (EditText)findViewById(R.id.editText);
        boton=(Button)findViewById(R.id.btnc);
        boton2=(Button)findViewById(R.id.button);
        campo_texto.getText().toString();

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aleatorio = (int) (Math.random() * 1000000) + 0;
                String valor=String.valueOf(aleatorio);
                aleator.setText(valor);
            }
        });

boton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        if (campo_texto.equals("")) {
    Toast.makeText(getApplicationContext(), "Introduzca un número", Toast.LENGTH_SHORT).show();
        }
        else {
    num = Integer.parseInt(campo_texto.getText().toString());
    convertidor(num);
    texto.setText(number);
        }
    }
});

}
    public  void convertidor(int num) {
        // String number="";
        //num = Integer.parseInt(campo_texto.getText().toString());

        String unidades[] =
                {"zero", "one", "two", "three", "four", "five",
                        "six", "seven", "eight", "nine", "ten"};
        String especiales[] =
                {"eleven", "twelve", "thirteen", "fourteen", "fiveteen",
                        "sixteen", "seventeen", "eighteen", "nineteen"};
        String decenas[] =
                {"twenty", "thirty", "forty", "fifty", "sixty",
                        "seventy", "eighty", "ninety"};


        if (num >= 0 && num < 11) {
            number = unidades[num];
            texto.setText(number);//Devueve números del 0 al 10
        } else if (num < 20) {
            number = especiales[num - 11];
            texto.setText(number);//número del 11 al 19
        } else if (num < 100) {
            int unid = num % 10;
            int dec = num / 10;

            if (unid == 0) {
                number = decenas[dec - 2];
                texto.setText(number);//Decenas enteras
            } else {
                number = (decenas[dec - 2] + " " + unidades[unid]);
                texto.setText(number);//decenas con unidades
            }

        }
        //centenas
        else if (num > 99 && num < 1000) {
            int cen = num / 100;
            int ce = num % 100;
            int de = ce / 10;
            int uni = ce % 10;

            if (ce == 0) {
                number = (unidades[cen] + " hundred ");
                texto.setText(number); //centenas de 100 en 100
            } else if (ce > 0 && ce < 11) {
                number = (unidades[cen] + " hundred" + unidades[ce]);
                texto.setText(number);//centenas del con unidades del 1 hasta la decena
            } else if (ce > 10 && ce < 20) {
                number = (unidades[cen] + " hundred " + especiales[ce - 11]);
                texto.setText(number);//centenas con numeros del 11 al 19
            } else if (ce > 19 && ce < 100) {
                if (uni == 0) {
                    number = (unidades[cen] + " hundred " + decenas[de - 2]);
                    texto.setText(number);
                } else {
                    number = (unidades[cen] + " hundred " + decenas[de - 2] + " " +
                            unidades[uni]);
                    texto.setText(number);

                }
            }


        }
        //millares
        else if (num >= 1000 && num < 11000) {
            int mil = num / 1000;
            int rMil = num % 1000;
            int cent = rMil / 100;
            int rCent = rMil % 100;
            int dece = rCent / 10;
            int unida = rCent % 10;

            if (rMil == 0) {
                number = (unidades[mil] + " thousand ");
                texto.setText(number);

            } else if (rMil > 0 && rMil < 11) {
                number = (unidades[mil] + " thousand " + unidades[rMil]);
                texto.setText(number);//centenas del con unidades del 1 hasta la decena
            } else if (rMil > 10 && rMil < 20) {

                number = (unidades[mil] + " thousand " + especiales[rMil - 11]);
                texto.setText(number);//centenas con numeros del 11 al 19

            } else if (rMil > 19 && rMil < 100) {
                if (unida == 0) {
                    number = (unidades[mil] + " thousand " + decenas[dece - 2]);
                    texto.setText(number);
                } else {
                    number = (unidades[mil] + " thousand " + decenas[dece - 2] + " " +
                            unidades[unida]);
                    texto.setText(number);

                }

            } else if (rMil > 99 && rMil < 1000) {

                if (rCent == 0) {
                    number = (unidades[mil] + " thousand " + unidades[cent] + " hundred ");
                    texto.setText(number);//centenas del con unidades del 1 hasta la decena
                } else if (rCent > 0 && rCent < 11) {
                    number = (unidades[mil] + " thousand " + unidades[cent] + " hundred " +
                            unidades[rCent]);
                    texto.setText(number);
                } else if (rCent > 10 && rCent < 20) {
                    number = (unidades[mil] + " thousand " + unidades[cent] + " hundred " +
                            especiales[rCent - 11]);
                    texto.setText(number);
                } else if (rCent > 19 && rCent < 100) {
                    if (unida == 0) {
                        number = (unidades[mil] + " thousand " + unidades[cent] + " hundred " +
                                decenas[dece - 2]);
                        texto.setText(number);
                    } else {
                        number = (unidades[mil] + " thousand " + unidades[cent] + " hundred " +
                                decenas[dece - 2] + " " + unidades[unida]);
                        texto.setText(number);
                    }
                }
            }
        } else if (num >= 11000 && num < 20000) {
            int mil = num / 1000;
            int rMil = num % 1000;
            int cent = rMil / 100;
            int rCent = rMil % 100;
            int dece = rCent / 10;
            int unida = rCent % 10;

            if (rMil == 0) {
                number = (especiales[mil - 11] + " thousand");
                texto.setText(number);

            } else if (rMil > 0 && rMil < 11) {
                number = (especiales[mil - 11] + " thousand " + unidades[rMil]);
                texto.setText(number);//centenas del con unidades del 1 hasta la decena
            } else if (rMil > 10 && rMil < 20) {

                number = (especiales[mil - 11] + " thousand " + especiales[rMil - 11]);
                texto.setText(number);//centenas con numeros del 11 al 19
            } else if (rMil > 19 && rMil < 100) {
                if (unida == 0) {
                    number = (especiales[mil - 11] + " thousand " + decenas[dece - 2]);
                    texto.setText(number);
                } else {
                    number = (especiales[mil - 11] + " thousand " + decenas[dece - 2] + " " +
                            unidades[unida]);
                    texto.setText(number);

                }
                //

            } else if (rMil > 99 && rMil < 1000) {

                if (rCent == 0) {
                    number = (especiales[mil - 11] + " thousand " + unidades[cent] + " hundred ");
                    texto.setText(number);//centenas del con unidades del 1 hasta la decena
                } else if (rCent > 0 && rCent < 11) {
                    number = (especiales[mil - 11] + " thousand " + unidades[cent] + " hundred " +
                            unidades[rCent]);
                    texto.setText(number);
                } else if (rCent > 10 && rCent < 20) {
                    number = (especiales[mil - 11] + " thousand " + unidades[cent] + " hundred " +
                            especiales[rCent - 11]);
                    texto.setText(number);
                } else if (rCent > 19 && rCent < 100) {
                    if (unida == 0) {
                        number = (especiales[mil - 11] + " thousand " + unidades[cent] + " hundred " +
                                decenas[dece - 2]);
                        texto.setText(number);
                    } else {
                        number = (especiales[mil - 11] + " thousand " + unidades[cent] + " hundred " +
                                decenas[dece - 2] + " " + unidades[unida]);
                        texto.setText(number);
                    }

                }


            }

        } else if (num >= 20000 && num < 100000) {
            int mil = num / 1000;
            int mDec = mil / 10;
            int mUni = mil % 10;
            int rMil = num % 1000;
            int cent = rMil / 100;
            int rCent = rMil % 100;
            int dece = rCent / 10;
            int unida = rCent % 10;

            if (mUni == 0) {

                if (rMil == 0) {
                    number = (decenas[mDec - 2] + " thousand");
                    texto.setText(number);

                } else if (rMil > 0 && rMil < 11) {
                    number = (decenas[mDec - 2] + " thousand " + unidades[rMil]);
                    texto.setText(number);//centenas del con unidades del 1 hasta la decena
                } else if (rMil > 10 && rMil < 20) {

                    number = (especiales[mDec - 2] + " thousand " + especiales[rMil - 11]);
                    texto.setText(number);//centenas con numeros del 11 al 19
                } else if (rMil > 19 && rMil < 100) {
                    if (unida == 0) {
                        number = (especiales[mDec - 2] + " thousand " + decenas[dece - 2]);
                        texto.setText(number);
                    } else {
                        number = (especiales[mDec - 2] + " thousand " + decenas[dece - 2] + " " +
                                unidades[unida]);
                        texto.setText(number);

                    }
                    //

                } else if (rMil > 99 && rMil < 1000) {

                    if (rCent == 0) {
                        number = (decenas[mDec - 2] + " thousand " + unidades[cent] + " hundred ");
                        texto.setText(number);//centenas del con unidades del 1 hasta la decena
                    } else if (rCent > 0 && rCent < 11) {
                        number = (decenas[mDec - 2] + " thousand " + unidades[cent] + " hundred " +
                                unidades[rCent]);
                        texto.setText(number);
                    } else if (rCent > 10 && rCent < 20) {
                        number = (decenas[mDec - 2] + " thousand " + unidades[cent] + " hundred " +
                                especiales[rCent - 11]);
                        texto.setText(number);
                    } else if (rCent > 19 && rCent < 100) {
                        if (unida == 0) {
                            number = (decenas[mDec - 2] + " thousand " + unidades[cent] + " hundred " +
                                    decenas[dece - 2]);
                            texto.setText(number);
                        } else {
                            number = (decenas[mDec - 2] + " thousand " + unidades[cent] + " hundred " +
                                    decenas[dece - 2] + " " + unidades[unida]);
                            texto.setText(number);
                        }

                    }


                }
            } else {

                if (rMil == 0) {
                    number = (decenas[mDec - 2] + " " + unidades[mUni] + " thousand");
                    texto.setText(number);

                } else if (rMil > 0 && rMil < 11) {
                    number = (decenas[mDec - 2] + " " + unidades[mUni] + " thousand " + unidades[rMil]);
                    texto.setText(number);//centenas del con unidades del 1 hasta la decena
                } else if (rMil > 10 && rMil < 20) {

                    number = (decenas[mDec - 2] + " " + unidades[mUni] + " thousand " + especiales[rMil - 11]);
                    texto.setText(number);//centenas con numeros del 11 al 19
                } else if (rMil > 19 && rMil < 100) {
                    if (unida == 0) {
                        number = (decenas[mDec - 2] + " " + unidades[mUni] + " thousand " + decenas[dece - 2]);
                        texto.setText(number);
                    } else {
                        number = (decenas[mDec - 2] + " " + unidades[mUni] + " thousand " + decenas[dece - 2] + " " +
                                unidades[unida]);
                        texto.setText(number);

                    }
                    //

                } else if (rMil > 99 && rMil < 1000) {

                    if (rCent == 0) {
                        number = (decenas[mDec - 2] + " " + unidades[mUni] + " thousand " + unidades[cent] + " hundred ");
                        texto.setText(number);//centenas del con unidades del 1 hasta la decena
                    } else if (rCent > 0 && rCent < 11) {
                        number = (decenas[mDec - 2] + " " + unidades[mUni] + " thousand " + unidades[cent] + " hundred " +
                                unidades[rCent]);
                        texto.setText(number);
                    } else if (rCent > 10 && rCent < 20) {
                        number = (decenas[mDec - 2] + " " + unidades[mUni] + " thousand " + unidades[cent] + " hundred " +
                                especiales[rCent - 11]);
                        texto.setText(number);
                    } else if (rCent > 19 && rCent < 100) {
                        if (unida == 0) {
                            number = (decenas[mDec - 2] + " " + unidades[mUni] + " thousand " + unidades[cent] + " hundred " +
                                    decenas[dece - 2]);
                            texto.setText(number);
                        } else {
                            number = (decenas[mDec - 2] + " " + unidades[mUni] + " thousand " + unidades[cent] + " hundred " +
                                    decenas[dece - 2] + " " + unidades[unida]);
                            texto.setText(number);
                        }

                    }


                }
            }
        } else if (num >= 100000 && num < 1000000) {
            int mil = num / 1000;
            int rMil = num % 1000;
            int mCent = mil / 100;
            int mRcen = mil % 100;
            int cent = rMil / 100;
            int mDec = mRcen / 10;
            int mUni = mRcen % 10;
            int rCent = rMil % 100;
            int dece = rCent / 10;
            int unida = rCent % 10;

            if (mRcen == 0) {

                if (rMil == 0) {
                    number = (unidades[mCent] + " hundred" + " thousand");
                    texto.setText(number);
                } else if (rMil > 0 && rMil < 11) {
                    number = (unidades[mCent] + " hundred" + " thousand " + unidades[rMil]);
                    texto.setText(number);//centenas del con unidades del 1 hasta la decena
                } else if (rMil > 10 && rMil < 20) {

                    number = (unidades[mCent] + " hundred" + " thousand " + especiales[rMil - 11]);
                    texto.setText(number);//centenas con numeros del 11 al 19
                } else if (rMil > 19 && rMil < 100) {
                    if (unida == 0) {
                        number = (unidades[mCent] + " hundred" + " thousand " + decenas[dece - 2]);
                        texto.setText(number);
                    } else {
                        number = (unidades[mCent] + " hundred" + " thousand " + decenas[dece - 2] + " " +
                                unidades[unida]);
                        texto.setText(number);

                    }
                    //

                } else if (rMil > 99 && rMil < 1000) {

                    if (rCent == 0) {
                        number = (unidades[mCent] + " hundred" + " thousand " + unidades[cent] + " hundred ");
                        texto.setText(number);//centenas del con unidades del 1 hasta la decena
                    } else if (rCent > 0 && rCent < 11) {
                        number = (unidades[mCent] + " hundred" + " thousand " + unidades[cent] + " hundred " +
                                unidades[rCent]);
                        texto.setText(number);
                    } else if (rCent > 10 && rCent < 20) {
                        number = (unidades[mCent] + " hundred" + " thousand " + unidades[cent] + " hundred " +
                                especiales[rCent - 11]);
                        texto.setText(number);
                    } else if (rCent > 19 && rCent < 100) {
                        if (unida == 0) {
                            number = (unidades[mCent] + " hundred" + " thousand " + unidades[cent] + " hundred " +
                                    decenas[dece - 2]);
                            texto.setText(number);
                        } else {
                            number = (unidades[mCent] + " hundred" + " thousand " + unidades[cent] + " hundred " +
                                    decenas[dece - 2] + " " + unidades[unida]);
                            texto.setText(number);
                        }

                    }


                }
            } else if (mRcen > 0 && mRcen < 11) {

                if (rMil == 0) {
                    number = (unidades[mCent] + " hundred" + " " + unidades[mRcen] + " thousand");
                    texto.setText(number);

                } else if (rMil > 0 && rMil < 11) {
                    number = (unidades[mCent] + " hundred" + " " + unidades[mRcen] + " thousand " + unidades[rMil]);
                    texto.setText(number);//centenas del con unidades del 1 hasta la decena
                } else if (rMil > 10 && rMil < 20) {

                    number = (unidades[mCent] + " hundred" + " " + unidades[mRcen] + " thousand " + especiales[rMil - 11]);
                    texto.setText(number);//centenas con numeros del 11 al 19
                } else if (rMil > 19 && rMil < 100) {
                    if (unida == 0) {
                        number = (unidades[mCent] + " hundred" + " " + unidades[mRcen] + " thousand " + decenas[dece - 2]);
                        texto.setText(number);
                    } else {
                        number = (unidades[mCent] + " hundred" + " " + unidades[mRcen] + " thousand " + decenas[dece - 2] + " " +
                                unidades[unida]);
                        texto.setText(number);

                    }
                    //

                } else if (rMil > 99 && rMil < 1000) {

                    if (rCent == 0) {
                        number = (unidades[mCent] + " hundred" + " " + unidades[mRcen] + " thousand " + unidades[cent] + " hundred ");
                        texto.setText(number);//centenas del con unidades del 1 hasta la decena
                    } else if (rCent > 0 && rCent < 11) {
                        number = (unidades[mCent] + " hundred" + " " + especiales[mRcen] + " thousand " + unidades[cent] + " hundred " +
                                unidades[rCent]);
                        texto.setText(number);
                    } else if (rCent > 10 && rCent < 20) {
                        number = (unidades[mCent] + " hundred" + " " + unidades[mRcen] + " thousand " + unidades[cent] + " hundred " +
                                especiales[rCent - 11]);
                        texto.setText(number);
                    } else if (rCent > 19 && rCent < 100) {
                        if (unida == 0) {
                            number = (unidades[mCent] + " hundred" + " " + unidades[mRcen] + " thousand " + unidades[cent] + " hundred " +
                                    decenas[dece - 2]);
                            texto.setText(number);
                        } else {
                            number = (unidades[mCent] + " hundred" + " " + unidades[mRcen] + " thousand " + unidades[cent] + " hundred " +
                                    decenas[dece - 2] + " " + unidades[unida]);
                            texto.setText(number);
                        }

                    }


                }
            } else if (mRcen >= 11 && mRcen < 20) {

                if (rMil == 0) {
                    number = (unidades[mCent] + " hundred" + " " + especiales[mRcen - 11] + " thousand");
                    texto.setText(number);

                } else if (rMil > 0 && rMil < 11) {
                    number = (unidades[mCent] + " hundred" + " " + especiales[mRcen - 11] + " thousand " + unidades[rMil]);
                    texto.setText(number);//centenas del con unidades del 1 hasta la decena
                } else if (rMil > 10 && rMil < 20) {

                    number = (unidades[mCent] + " hundred" + " " + especiales[mRcen - 11] + " thousand " + especiales[rMil - 11]);
                    texto.setText(number);//centenas con numeros del 11 al 19
                } else if (rMil > 19 && rMil < 100) {
                    if (unida == 0) {
                        number = (unidades[mCent] + " hundred" + " " + especiales[mRcen - 11] + " thousand " + decenas[dece - 2]);
                        texto.setText(number);
                    } else {
                        number = (unidades[mCent] + " hundred" + " " + especiales[mRcen - 11] + " thousand " + decenas[dece - 2] + " " +
                                unidades[unida]);
                        texto.setText(number);

                    }
                    //

                } else if (rMil > 99 && rMil < 1000) {

                    if (rCent == 0) {
                        number = (unidades[mCent] + " hundred" + " " + especiales[mRcen - 11] + " thousand " + unidades[cent] + " hundred ");
                        texto.setText(number);//centenas del con unidades del 1 hasta la decena
                    } else if (rCent > 0 && rCent < 11) {
                        number = (unidades[mCent] + " hundred" + " " + especiales[mRcen - 11] + " thousand " + unidades[cent] + " hundred " +
                                unidades[rCent]);
                        texto.setText(number);
                    } else if (rCent > 10 && rCent < 20) {
                        number = (unidades[mCent] + " hundred" + " " + especiales[mRcen - 11] + " thousand " + unidades[cent] + " hundred " +
                                especiales[rCent - 11]);
                        texto.setText(number);
                    } else if (rCent > 19 && rCent < 100) {
                        if (unida == 0) {
                            number = (unidades[mCent] + " hundred" + " " + especiales[mRcen - 11] + " thousand " + unidades[cent] + " hundred " +
                                    decenas[dece - 2]);
                            texto.setText(number);
                        } else {
                            number = (unidades[mCent] + " hundred" + " " + especiales[mRcen - 11] + " thousand " + unidades[cent] + " hundred " +
                                    decenas[dece - 2] + " " + unidades[unida]);
                            texto.setText(number);
                        }

                    }


                }
            }
//
            else if (mRcen >= 20 && mRcen < 99) {
                if (mUni == 0) {
                    if (rMil == 0) {
                        number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " thousand");
                        texto.setText(number);

                    } else if (rMil > 0 && rMil < 11) {
                        number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " thousand " + unidades[rMil]);
                        texto.setText(number);//centenas del con unidades del 1 hasta la decena
                    } else if (rMil > 10 && rMil < 20) {

                        number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " thousand " + especiales[rMil - 11]);
                        texto.setText(number);//centenas con numeros del 11 al 19
                    } else if (rMil > 19 && rMil < 100) {
                        if (unida == 0) {
                            number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " thousand " + decenas[dece - 2]);
                            texto.setText(number);
                        } else {
                            number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " thousand " + decenas[dece - 2] + " " +
                                    unidades[unida]);
                            texto.setText(number);

                        }
                        //

                    } else if (rMil > 99 && rMil < 1000) {

                        if (rCent == 0) {
                            number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " thousand " + unidades[cent] + " hundred ");
                            texto.setText(number);//centenas del con unidades del 1 hasta la decena
                        } else if (rCent > 0 && rCent < 11) {
                            number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " thousand " + unidades[cent] + " hundred " +
                                    unidades[rCent]);
                            texto.setText(number);
                        } else if (rCent > 10 && rCent < 20) {
                            number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " thousand " + unidades[cent] + " hundred " +
                                    especiales[rCent - 11]);
                            texto.setText(number);
                        } else if (rCent > 19 && rCent < 100) {
                            if (unida == 0) {
                                number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " thousand " + unidades[cent] + " hundred " +
                                        decenas[dece - 2]);
                                texto.setText(number);
                            } else {
                                number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " thousand " + unidades[cent] + " hundred " +
                                        decenas[dece - 2] + " " + unidades[unida]);
                                texto.setText(number);
                            }

                        }


                    }
                }
            }//
            else {
                if (rMil == 0) {
                    number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " " +
                            unidades[mUni] + " thousand");
                    texto.setText(number);

                } else if (rMil > 0 && rMil < 11) {
                    number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " " +
                            unidades[mUni] + " thousand " + unidades[rMil]);
                    texto.setText(number);//centenas del con unidades del 1 hasta la decena
                } else if (rMil > 10 && rMil < 20) {

                    number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " " +
                            unidades[mUni] + " thousand " + especiales[rMil - 11]);
                    texto.setText(number);//centenas con numeros del 11 al 19
                } else if (rMil > 19 && rMil < 100) {
                    if (unida == 0) {
                        number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " " +
                                unidades[mUni] + " thousand " + decenas[dece - 2]);
                        texto.setText(number);
                    } else {
                        number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " " +
                                unidades[mUni] + " thousand " + decenas[dece - 2] + " " +
                                unidades[unida]);
                        texto.setText(number);

                    }
                    //

                } else if (rMil > 99 && rMil < 1000) {

                    if (rCent == 0) {
                        number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " " +
                                unidades[mUni] + " thousand " + unidades[cent] + " hundred ");
                        texto.setText(number);//centenas del con unidades del 1 hasta la decena
                    } else if (rCent > 0 && rCent < 11) {
                        number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " " +
                                unidades[mUni] + " thousand " + unidades[cent] + " hundred " +
                                unidades[rCent]);
                        texto.setText(number);
                    } else if (rCent > 10 && rCent < 20) {
                        number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " " +
                                unidades[mUni] + " thousand " + unidades[cent] + " hundred " +
                                especiales[rCent - 11]);
                        texto.setText(number);
                    } else if (rCent > 19 && rCent < 100) {
                        if (unida == 0) {
                            number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " " +
                                    unidades[mUni] + " thousand " + unidades[cent] + " hundred " +
                                    decenas[dece - 2]);
                            texto.setText(number);
                        } else {
                            number = (unidades[mCent] + " hundred" + " " + decenas[mDec - 2] + " " +
                                    unidades[mUni] + " thousand " + unidades[cent] + " hundred " +
                                    decenas[dece - 2] + " " + unidades[unida]);
                            texto.setText(number);
                        }

                    }


                }
            }
        } else if (num == 1000000) {
            number = (" one million");
            texto.setText(number);//centenas del con unidades del 1 hasta la decena


        } else
            Toast.makeText(getApplicationContext(), '\n' + " El numero debe ser menor a 100000", Toast.LENGTH_LONG).show();


    }
}





