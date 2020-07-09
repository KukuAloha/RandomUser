package com.example.randomuser;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomuser.data.Result;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {
    private List<Result> results;

    public InfoAdapter(List<Result> results, SecondActivity secondActivity){
        this.results = results;
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder {

        TextView textGender, textLocation, textEmail, textDob, textPhone;

        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            textGender = itemView.findViewById(R.id.textGender);
            textLocation = itemView.findViewById(R.id.textLocation);
            textEmail = itemView.findViewById(R.id.textEmail);
            textDob = itemView.findViewById(R.id.textDob);
            textPhone = itemView.findViewById(R.id.textPhone);
        }
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item, parent,false);
        return new InfoViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        holder.textGender.setText("Gender: " + results.get(position).getGender());
        holder.textLocation.setText("Location: \n   " + results.get(position).getLocation().getCity()
                + "\n   " + results.get(position).getLocation().getState()
                + "\n   " + results.get(position).getLocation().getPostcode()
                + "\nCoordinates:\n    " + results.get(position).getLocation().getCoordinates().getLatitude()
                + "\n   " + results.get(position).getLocation().getCoordinates().getLongitude());
        holder.textEmail.setText("Email: \n    " + results.get(position).getEmail());
        holder.textDob.setText("Date of Birth: \n   " + results.get(position).getDob().getDate());
        holder.textPhone.setText("Phone Number: \n   " + results.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
