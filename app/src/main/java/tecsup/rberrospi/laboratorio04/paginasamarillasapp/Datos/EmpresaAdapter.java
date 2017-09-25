package tecsup.rberrospi.laboratorio04.paginasamarillasapp.Datos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import tecsup.rberrospi.laboratorio04.paginasamarillasapp.R;

public class EmpresaAdapter extends ArrayAdapter {
    int[] imageArray;
    String[] nombreArray;
    String[] direcArray;
    String[] telefArray;

    public EmpresaAdapter(Context context, String[] nombres, String[] direcciones, String[] telefonos, int[] img1) {
        //Overriding Default Constructor off ArratAdapter
        super(context, R.layout.list, R.id.idNombre, nombres);
        this.imageArray = img1;
        this.nombreArray = nombres;
        this.direcArray = direcciones;
        this.telefArray = telefonos;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Inflating the layout
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list, parent, false);

        //Get the reference to the view objects
        ImageView myImage = (ImageView) row.findViewById(R.id.idPic);
        TextView myTitle = (TextView) row.findViewById(R.id.idNombre);
        TextView myDescription = (TextView) row.findViewById(R.id.idDireccion);
        TextView myTelefono = (TextView) row.findViewById(R.id.idTelefono);

        //Providing the element of an array by specifying its position
        myImage.setImageResource(imageArray[position]);
        myTitle.setText(nombreArray[position]);
        myDescription.setText(direcArray[position]);
        myTelefono.setText(telefArray[position]);
        return row;
    }
}
