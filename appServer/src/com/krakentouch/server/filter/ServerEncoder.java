package com.krakentouch.server.filter;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerEncoder implements ProtocolEncoder{
	private static final Logger LOG = LoggerFactory.getLogger(ServerEncoder.class);

	@Override
	public void dispose(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void encode(IoSession session, Object obj, ProtocolEncoderOutput out)
			throws Exception {
		LOG.debug("encode(...)");
		out.write(obj);
	}

}
