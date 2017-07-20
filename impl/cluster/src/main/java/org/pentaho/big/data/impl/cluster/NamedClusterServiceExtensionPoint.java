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
 */
@ExtensionPoint( id = "NamedClusterServiceMetaLoadExtensionPoint", extensionPointId = "TransformationMetaLoaded",
  description = "" )
public class NamedClusterServiceExtensionPoint implements ExtensionPointInterface {
    NamedClusterServiceOsgi namedClusterServiceOsgi;

    public NamedClusterServiceExtensionPoint( NamedClusterService namedClusterService ) {
      namedClusterServiceOsgi = new NamedClusterServiceOsgiImpl( namedClusterService );
    }

    @Override public void callExtensionPoint( LogChannelInterface log, Object object ) throws KettleException {
      TransMeta transMeta = (TransMeta) object;
      transMeta.setNamedClusterServiceOsgi( namedClusterServiceOsgi );
    }
}
