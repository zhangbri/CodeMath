package com.codepath.codemath
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.EditText
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.content.ContextCompat
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var partySpinner: Spinner
    private lateinit var seekBar: SeekBar
    private lateinit var percentageTextView: TextView
    private lateinit var baseEditText: EditText
    private lateinit var totalAmountTextView: TextView
    private lateinit var tipAmountTextView: TextView
    private lateinit var feedbackTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        seekBar = findViewById<SeekBar>(R.id.seekBar)
        percentageTextView = findViewById<TextView>(R.id.Percentage)
        baseEditText = findViewById<EditText>(R.id.editTextNumber)
        totalAmountTextView = findViewById<TextView>(R.id.TotalAmount)
        tipAmountTextView = findViewById<TextView>(R.id.NumberOnly)
        partySpinner = findViewById(R.id.partySpinner)
        feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)

        tipAmountTextView.text = ""
        totalAmountTextView.text = ""

        setupSeekBar()
        setupEditText()
        setupSpinner()
    }

    private fun calculateTotalAndPercentage(partySize: Int = 1) {
        val baseAmountText = baseEditText.text.toString()
        if (baseAmountText.isNotEmpty()) {
            val baseAmount = baseAmountText.toDoubleOrNull()
            if (baseAmount != null && baseAmount > 0) {
                val tipPercentage = seekBar.progress
                val tipAmount = baseAmount * (tipPercentage / 100.0)
                val totalAmount = baseAmount + tipAmount
                val totalPerPerson = totalAmount / partySize
                val tipPerPerson = tipAmount / partySize
                val decimalFormat = DecimalFormat("#0.00")

                percentageTextView.text = "$tipPercentage%"
                tipAmountTextView.text = decimalFormat.format(tipPerPerson)
                totalAmountTextView.text = decimalFormat.format(totalPerPerson)
                val feedbackAndColor = when (tipPercentage) {
                    in 20..30 -> Pair("Amazing!", R.color.amazing)
                    in 15..19 -> Pair("Good", R.color.good)
                    in 10..14 -> Pair("Acceptable", R.color.acceptable)
                    in 0..9 -> Pair("Poor", R.color.poor)
                    else -> Pair("", null) // Default case
                }
                feedbackTextView.text = feedbackAndColor.first

                feedbackAndColor.second?.let {
                    feedbackTextView.setTextColor(ContextCompat.getColor(this, it))
                }

            } else {
                tipAmountTextView.text = ""
                totalAmountTextView.text = ""
                feedbackTextView.text = ""
            }
        }
    }

    private fun setupSeekBar() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                calculateTotalAndPercentage(partySpinner.selectedItemPosition + 1)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })
    }

    private fun setupEditText() {
        baseEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                calculateTotalAndPercentage(partySpinner.selectedItemPosition + 1)
            }
        })
    }

    private fun setupSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.party_numbers,
            R.layout.spinner_item
        )
        adapter.setDropDownViewResource(R.layout.dropdown_item)
        partySpinner.adapter = adapter

        partySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                calculateTotalAndPercentage(position + 1)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }
}