package com.rstenal.mhbl.jmhblclient.gui;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.rstenal.mhbl.jmhblclient.model.BloodPressure;
import com.rstenal.mhbl.jmhblclient.model.builders.BloodPressureBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;

public class BloodPressureTM extends BaseTableModel<BloodPressure> {

    private static final String COLUMN_NAME_UNDEFINE = "Unknown";
    private static final String COLUMN_NAME_DESCRIPTION = "Description";
    private static final String COLUMN_NAME_PRESSURE_TIME = "Pressure time";
    private static final String COLUMN_NAME_PULSE = "Pulse";
    private static final String COLUMN_NAME_DIASTOLIC = "Diastolic";
    private static final String COLUMN_NAME_SYSTOLIC = "Systolic";
    private static final String COLUMN_NAME_ORDER_NUMBER = "Lp.";

    private String url;
    private String user;
    private String password;

    private static class BpCallback implements Callback<JsonNode> {

        private final BloodPressureTM model;
        private final Calendar callendar;

        public BpCallback(BloodPressureTM model) {
            this.model = model;
            callendar = GregorianCalendar.getInstance();
        }

        @Override
        public void completed(HttpResponse<JsonNode> response) {
            JsonNode body = response.getBody();

            JSONArray root = body.getArray();
            for (int i=0; i<root.length(); i++) {
                JSONObject jsonObject = root.getJSONObject(i);
                BloodPressure bp = new BloodPressureBuilder()
                        .withSystolic(jsonObject.getInt("systolic"))
                        .withDiastolic(jsonObject.getInt("diastolic"))
                        .withPulse(jsonObject.getInt("pulse"))
                        .withOccurrence(transformDate(jsonObject.getLong("occurrence")))
                        .build();
                this.model.dataQueue.add(bp);
            }

            this.model.fireTableDataChanged();
        }

        @Override
        public void failed(UnirestException e) {

        }

        @Override
        public void cancelled() {

        }

        private Date transformDate(long millis) {
            callendar.setTimeInMillis(millis);

            return callendar.getTime();
        }
    }

    public BloodPressureTM(String url, String u, String p) throws ExecutionException, InterruptedException {
        super();
        user = u;
        password = p;
        this.url = url;

        Unirest.get(url)
                .basicAuth(user, password)
                .header("accept", "application/json")
                .asJsonAsync(new BpCallback(this));
    }

    @Override
    public int getRowCount() {
        return this.dataQueue.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return Integer.class;
            case 2:
                return Integer.class;
            case 3:
                return Integer.class;
            case 4:
                return Date.class;
            case 5:
                return String.class;
            default:
                return Object.class;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return COLUMN_NAME_ORDER_NUMBER;
            case 1:
                return COLUMN_NAME_SYSTOLIC;
            case 2:
                return COLUMN_NAME_DIASTOLIC;
            case 3:
                return COLUMN_NAME_PULSE;
            case 4:
                return COLUMN_NAME_PRESSURE_TIME;
            case 5:
                return COLUMN_NAME_DESCRIPTION;
            default:
                return COLUMN_NAME_UNDEFINE;
        }

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return dataQueue.get(rowIndex).getSystolic();
            case 2:
                return dataQueue.get(rowIndex).getDiastolic();
            case 3:
                return dataQueue.get(rowIndex).getPulse();
            case 4:
                return dataQueue.get(rowIndex).getOccurrence();
            case 5:
                return dataQueue.get(rowIndex).getDescription();
            default:
                return "";
        }
    }

}
