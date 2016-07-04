package mx.redhat.fuse.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

import mx.redhat.fuse.service.BpmService;

public class ReposProcessor implements Processor {

	private static Logger log = Logger.getLogger(ReposProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		log.info("**********Getting repositories*************");
		exchange.getIn().setBody(BpmService.getDataFromService("repositories"));
	}

}
