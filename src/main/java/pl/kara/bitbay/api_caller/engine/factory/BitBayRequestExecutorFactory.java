package pl.kara.bitbay.api_caller.engine.factory;

import pl.kara.bitbay.api_caller.BitBayRequestExecutor;
import pl.kara.bitbay.api_caller.BitBayClient;

public interface BitBayRequestExecutorFactory {

    BitBayRequestExecutor createFor(final BitBayClient client);

}
