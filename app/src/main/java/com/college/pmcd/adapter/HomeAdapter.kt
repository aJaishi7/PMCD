package com.college.pmcd.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.college.pmcd.R
import com.college.pmcd.model.Disease
import org.w3c.dom.Text

class HomeAdapter(val context: Context, val listOfDisease: ArrayList<Disease>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val tvDiseaseTitle: TextView
        val tvCauses: TextView
        val tvSymptoms: TextView
        val tvPreventiveMeasures: TextView
        val tvEatables: TextView

        init {
            tvDiseaseTitle = v.findViewById(R.id.tvDiseaseTitle);
            tvCauses = v.findViewById(R.id.tvCauses);
            tvSymptoms = v.findViewById(R.id.tvSymptoms);
            tvPreventiveMeasures = v.findViewById(R.id.tvPreventiveMeasure);
            tvEatables = v.findViewById(R.id.tvEatables);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.disease_recycler_view, parent, false);
        return HomeViewHolder(view);
    }

    override fun getItemCount(): Int {
        return listOfDisease.size;
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val disease: Disease = listOfDisease[position];
        holder.tvDiseaseTitle.text = disease.diseaseTitle.toString();
    }
}