package org.nadeeshaan.d3dsl.ls;

import com.google.inject.AbstractModule;
import java.util.concurrent.ExecutorService;
import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.xtext.ide.ExecutorServiceProvider;
import org.eclipse.xtext.ide.server.DefaultProjectDescriptionFactory;
import org.eclipse.xtext.ide.server.IMultiRootWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.IProjectDescriptionFactory;
import org.eclipse.xtext.ide.server.MultiRootWorkspaceConfigFactory;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.ResourceServiceProviderServiceLoader;
import org.eclipse.xtext.resource.containers.ProjectDescriptionBasedContainerManager;
import org.nadeeshaan.d3dsl.ide.D3DslLanguageServerImpl;

/** Language Server Module. */
public class LanguageServerModule extends AbstractModule {
  protected void configure() {
    this.binder().bind(ExecutorService.class).toProvider(ExecutorServiceProvider.class);
    this.bind(LanguageServer.class).to(D3DslLanguageServerImpl.class);
    this.bind(IResourceServiceProvider.Registry.class)
        .toProvider(ResourceServiceProviderServiceLoader.class);
    this.bind(IMultiRootWorkspaceConfigFactory.class).to(MultiRootWorkspaceConfigFactory.class);
    this.bind(IProjectDescriptionFactory.class).to(DefaultProjectDescriptionFactory.class);
    this.bind(IContainer.Manager.class).to(ProjectDescriptionBasedContainerManager.class);
  }
}
