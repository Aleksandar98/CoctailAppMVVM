package com.aca.coctailappmvvm.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.aca.coctailappmvvm.R;
import com.aca.coctailappmvvm.models.Coctail;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapterCoctailList extends RecyclerView.Adapter<RecyclerAdapterCoctailList.CoctailListViewHolder> {

    private List<Coctail> coctails;

    public RecyclerAdapterCoctailList(List<Coctail> coctails) {
        this.coctails = coctails;
    }

    @NonNull
    @Override
    public CoctailListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coctail_list_element,parent,false);
        return new CoctailListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoctailListViewHolder viewHolder, int position) {
        viewHolder.getImeKoktela().setText(coctails.get(position).getDrinkName());
        viewHolder.getOpisKoktela().setText(coctails.get(position).getDrinkType());
        Glide.with(viewHolder.getSlikaKoktela()).load(coctails.get(position).getDrinkImg()).centerCrop().into(viewHolder.getSlikaKoktela());
    }

    @Override
    public int getItemCount() {
        return coctails.size();
    }


    class CoctailListViewHolder extends RecyclerView.ViewHolder{

        private final TextView imeKoktela;
        private final TextView opisKoktela;
        private final ImageView slikaKoktela;

        public CoctailListViewHolder(@NonNull View itemView) {
            super(itemView);

            imeKoktela = (TextView) itemView.findViewById(R.id.imeKoktela);
            opisKoktela = (TextView) itemView.findViewById(R.id.opisKoktela);
            slikaKoktela = (ImageView) itemView.findViewById(R.id.slikaKoktela);

        }

        public TextView getImeKoktela() {
            return imeKoktela;
        }
        public TextView getOpisKoktela() {
            return opisKoktela;
        }
        public ImageView getSlikaKoktela() {
            return slikaKoktela;
        }
    }
}
