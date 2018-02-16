/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2018 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.big.data.kettle.plugins.formats.avro.output;

import org.pentaho.big.data.kettle.plugins.formats.BaseFormatOutputField;
import org.pentaho.di.core.injection.Injection;
import org.pentaho.hadoop.shim.api.format.AvroSpec;
import org.pentaho.hadoop.shim.api.format.IAvroOutputField;

/**
 * Base class for format's input/output field - path added.
 * 
 * @author JRice <joseph.rice@hitachivantara.com>
 */
public class AvroOutputField extends BaseFormatOutputField implements IAvroOutputField {
  @Override
  public AvroSpec.DataType getAvroType() {
    return AvroSpec.DataType.values()[ formatType ];
  }

  @Override
  public void setFormatType( AvroSpec.DataType avroType ) {
    this.formatType = avroType.ordinal();
  }

  @Override
  public void setFormatType( int formatType ) {
    for ( AvroSpec.DataType avroType : AvroSpec.DataType.values() ) {
      if ( avroType.ordinal() == formatType ) {
        this.formatType = formatType;
      }
    }
  }

  @Injection( name = "FIELD_TYPE", group = "FIELDS" )
  public void setFormatType( String typeName ) {
    try  {
      setFormatType( Integer.parseInt( typeName ) );
    } catch ( NumberFormatException nfe ) {
      for ( AvroSpec.DataType avroType : AvroSpec.DataType.values() ) {
        if ( avroType.getName().equals( typeName ) ) {
          this.formatType = avroType.ordinal();
        }
      }
    }
  }

  public boolean isDecimalType() {
    return getAvroType().getName().equals( AvroSpec.DataType.DECIMAL.getName() );
  }

  @Override
  public void setPrecision( String precision ) {
    if ( precision == null ) {
      this.precision = AvroSpec.DEFAULT_DECIMAL_PRECISION;
    } else {
      this.precision = Integer.valueOf( precision );
      if ( this.precision <= 0 ) {
        this.precision = AvroSpec.DEFAULT_DECIMAL_PRECISION;
      }
    }
  }

  @Override
  public void setScale( String scale ) {
    if ( scale == null ) {
      this.scale = AvroSpec.DEFAULT_DECIMAL_SCALE;
    } else {
      this.scale = Integer.valueOf( scale );
      if ( this.scale < 0 ) {
        this.scale = AvroSpec.DEFAULT_DECIMAL_SCALE;
      }
    }
  }
}
