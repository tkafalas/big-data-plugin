package org.pentaho.big.data.impl.cluster;

import org.pentaho.big.data.api.cluster.NamedClusterService;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.extension.ExtensionPoint;
import org.pentaho.di.core.extension.ExtensionPointInterface;
import org.pentaho.di.core.logging.LogChannelInterface;
import org.pentaho.di.core.osgi.api.NamedClusterServiceOsgi;
import org.pentaho.di.trans.TransMeta;


/**
 * Created by tkafalas on 7/14/2017.
 *  * <p>
 * This class exists because two ExtensionPoint annotations are not allowed on the same class
 */
@ExtensionPoint( id = "NamedClusterServiceNewTransExtensionPoint", extensionPointId = "TransformationCreateNew",
  description = "" )
public class NamedClusterServiceNewTransExtensionPoint extends NamedClusterServiceExtensionPoint {
  NamedClusterServiceOsgi namedClusterServiceOsgi;

  public NamedClusterServiceNewTransExtensionPoint( NamedClusterService namedClusterService ) {
    super( namedClusterService );
  }
}
