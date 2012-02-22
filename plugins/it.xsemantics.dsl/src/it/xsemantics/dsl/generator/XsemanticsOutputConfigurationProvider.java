package it.xsemantics.dsl.generator;

import java.util.Set;

import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationProvider;

public class XsemanticsOutputConfigurationProvider extends
		OutputConfigurationProvider {

	public static final String XSEMANTICS_GEN = "./xsemantics-gen";

	@Override
	public Set<OutputConfiguration> getOutputConfigurations() {
		Set<OutputConfiguration> outputconfigurations = super
				.getOutputConfigurations();
		OutputConfiguration outputConfiguration = outputconfigurations
				.iterator().next();
		outputConfiguration.setOutputDirectory(XSEMANTICS_GEN);
		return outputconfigurations;
	}

}
