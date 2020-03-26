package ru.pfr.fromfms;

import java.util.ArrayList;
import java.util.List;

public class ResponceFromFms {
   public List<RowFromFms> rowsFromFms(RowFromFms rowFromFms){
            List<RowFromFms> rows =new ArrayList<RowFromFms>();
            rows.add(rowFromFms);
       return rows ;
   }

}
