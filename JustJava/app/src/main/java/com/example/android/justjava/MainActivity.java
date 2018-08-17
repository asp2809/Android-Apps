/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    CheckBox checkbox1, checkbox2;
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText edit1 = findViewById(R.id.edit1);
        displayMessage(createOrderSummary(calculatePrice()), edit1.getText().toString());
    }

    public void increment(View view) {
        if(quantity < 100)
            quantity = quantity + 1;
        else if(quantity == 100)
            Toast.makeText(getApplicationContext(), "You can order a max of 100 coffees", Toast.LENGTH_SHORT).show();
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if(quantity > 1)
            quantity = quantity - 1;
        else if(quantity == 1)
            Toast.makeText(getApplicationContext(), "You can't order less than one coffee", Toast.LENGTH_SHORT).show();
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int n) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + n);
    }

    /* This method cretes an order summary to display when the user presses order button
    *
    **/
    private String createOrderSummary(int price) {
        EditText edit1 = findViewById(R.id.edit1);
        CheckBox checkbox1 = findViewById(R.id.checkbox1);
        CheckBox checkbox2 = findViewById(R.id.checkbox2);
        return "Name: " + edit1.getText().toString() + "\n" + "Add Whipped Cream?" + checkbox1.isChecked() + "\nAdd Chocolate?" + checkbox2.isChecked() + "\nQuantity: " + quantity + "\nTotal: $" + price + "\nThank You!\n";
    }
    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
        CheckBox checkbox1 = findViewById(R.id.checkbox1);
        CheckBox checkbox2 = findViewById(R.id.checkbox2);
        int pricepercoffee = 5;
        if(checkbox1.isChecked())
        {
            pricepercoffee+=1;
        }
        if(checkbox2.isChecked())
        {
            pricepercoffee+=2;
        }
        int price = quantity * pricepercoffee;
        return price;
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message, String name) {
        Intent obj = new Intent(Intent.ACTION_SENDTO);
        obj.setData(Uri.parse("mailto:"));
        obj.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for " + name);
        obj.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(obj);
    }
}