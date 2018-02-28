package org.pentaho.big.data.kettle.plugins.formats.parquet.input;

import org.pentaho.big.data.kettle.plugins.formats.BaseFormatInputField;
import org.pentaho.di.core.row.value.ValueMetaFactory;
import org.pentaho.hadoop.shim.api.format.IParquetInputField;
import org.pentaho.hadoop.shim.api.format.ParquetSpec;

public class ParquetInputField extends BaseFormatInputField implements IParquetInputField {
  @Override
  public void setParquetType( ParquetSpec.DataType parquetType ) {
    setFormatType( parquetType.getId() );
  }

  @Override
  public void setParquetType( String parquetType ) {
    for ( ParquetSpec.DataType tmpType : ParquetSpec.DataType.values() ) {
      if ( tmpType.getName().equalsIgnoreCase( parquetType ) ) {
        setFormatType( tmpType.getId() );
        break;
      }
    }
  }

  @Override
  public ParquetSpec.DataType getParquetType() {
    return ParquetSpec.DataType.getDataType( getFormatType() );
  }

  public String getTypeDesc() {
    return ValueMetaFactory.getValueMetaName( getPentahoType() );
  }
}
