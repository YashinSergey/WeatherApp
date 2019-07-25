package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private final ItemSource dataSource;

    public ItemAdapter(ItemSource  dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = dataSource.getItem(position);
        holder.setData(item.getSymbol(), item.getTemperature(), item.getCelsius(),
                item.getAtmPhenomena(), item.getPressure(), item.getMmHg());
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView symbol;
        private TextView temperature;
        private TextView celsius;
        private TextView atmPhenomena;
        private TextView pressure;
        private TextView mmHg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            symbol = itemView.findViewById(R.id.symbol);
            temperature = itemView.findViewById(R.id.temperature);
            celsius = itemView.findViewById(R.id.celsius);
            atmPhenomena = itemView.findViewById(R.id.atmospheric_phenomena);
            pressure = itemView.findViewById(R.id.mon_pressure);
            mmHg = itemView.findViewById(R.id.mm_Hg);
        }

        private void setData(String symbol, String temperature, String celsius, String atmPhenomena, String pressure, String mmHg) {
            getSymbol().setText(symbol);
            getTemperature().setText(temperature);
            getCelsius().setText(celsius);
            getAtmPhenomena().setText(atmPhenomena);
            getPressure().setText(pressure);
            getMmHg().setText(mmHg);
        }

        public TextView getSymbol() {
            return symbol;
        }

        public TextView getTemperature() {
            return temperature;
        }

        public TextView getCelsius() {
            return celsius;
        }

        public TextView getAtmPhenomena() {
            return atmPhenomena;
        }

        public TextView getPressure() {
            return pressure;
        }

        public TextView getMmHg() {
            return mmHg;
        }
    }
}
