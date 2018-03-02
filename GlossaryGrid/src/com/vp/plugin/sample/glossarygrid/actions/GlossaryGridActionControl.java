package com.vp.plugin.sample.glossarygrid.actions;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.DiagramManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IDiagramTypeConstants;
import com.vp.plugin.diagram.IGridDiagramUIModel;
import com.vp.plugin.model.IAlias;
import com.vp.plugin.model.IGlossary;
import com.vp.plugin.model.IGlossaryLabel;
import com.vp.plugin.model.IGridDiagramColumn;
import com.vp.plugin.model.IGridDiagramColumnContainer;
import com.vp.plugin.model.IModelElement;
import com.vp.plugin.model.factory.IModelElementFactory;

public class GlossaryGridActionControl implements VPActionController {

	@Override
	public void performAction(VPAction arg0) {
		
		// Create glossary term and alias for Discussion 
		IGlossary glossaryDiscussion = IModelElementFactory.instance().createGlossary();
		glossaryDiscussion.setName("Discussion");
		glossaryDiscussion.setDescription("Thoughts from users about the TV programs.");
		
		IAlias aliasForum = IModelElementFactory.instance().createAlias();
		aliasForum.setName("Forum");
		glossaryDiscussion.addAliase(aliasForum);
		
		
		// Create glossary term for Archived
		IGlossary glossaryArchived = IModelElementFactory.instance().createGlossary();
		glossaryArchived.setName("Archived");
		glossaryArchived.setDescription("TV program that was played 3 days ago.");
		
		IAlias aliasOld = IModelElementFactory.instance().createAlias();
		aliasOld.setName("Old");
		glossaryArchived.addAliase(aliasOld);
		
		IAlias aliasExpired = IModelElementFactory.instance().createAlias();
		aliasExpired.setName("Expired");
		glossaryArchived.addAliase(aliasExpired);
		
		
		// Create glossary term for Premium Member
		IGlossary glossaryPremiumMember = IModelElementFactory.instance().createGlossary();
		glossaryPremiumMember.setName("Premium Member");
		glossaryPremiumMember.setDescription("People who are paid and are allow to watch paid TV programs.");
		
		IAlias aliasVIPMember = IModelElementFactory.instance().createAlias();
		aliasVIPMember.setName("VIP member");
		glossaryPremiumMember.addAliase(aliasVIPMember);

		IAlias aliasGoldMember = IModelElementFactory.instance().createAlias();
		aliasGoldMember.setName("Gold Member");
		glossaryPremiumMember.addAliase(aliasGoldMember);
		
		
		// Create glossary term for general Member
		IGlossary glossaryGeneralMember = IModelElementFactory.instance().createGlossary();
		glossaryGeneralMember.setName("General Member");
		glossaryGeneralMember.setDescription("People who can watch free TV programs.");
		
		
		// Create glossary term for Register
		IGlossary glossaryRegister = IModelElementFactory.instance().createGlossary();
		glossaryRegister.setName("Register");
		glossaryRegister.setDescription("The process to become a paid member of the system.");
		
		IAlias aliasSignUp = IModelElementFactory.instance().createAlias();
		aliasSignUp.setName("Sign-up");
		glossaryRegister.addAliase(aliasSignUp);
		
		IAlias aliasSignUp2 = IModelElementFactory.instance().createAlias();
		aliasSignUp2.setName("Signup");
		glossaryRegister.addAliase(aliasSignUp2);

		
		// Create glossary term for Live
		IGlossary glossaryLive = IModelElementFactory.instance().createGlossary();
		glossaryLive.setName("Live");
		glossaryLive.setDescription("TV program that plays at the moment.");


		// Create glossary term for Newsletter
		IGlossary glossaryNewsletter = IModelElementFactory.instance().createGlossary();
		glossaryNewsletter.setName("Newsletter");
		glossaryNewsletter.setDescription("Eail that presents the recommended TV programs.");
		
		IAlias aliasBulletin = IModelElementFactory.instance().createAlias();
		aliasBulletin.setName("Bulletin");
		glossaryNewsletter.addAliase(aliasBulletin);

		
		// Create glossary term for Timetable
		IGlossary glossaryTimetable = IModelElementFactory.instance().createGlossary();
		glossaryTimetable.setName("Timetable");
		glossaryTimetable.setDescription("The schedule of TV programs.");

		IAlias aliasSchedule = IModelElementFactory.instance().createAlias();
		aliasSchedule.setName("Schedule");
		glossaryTimetable.addAliase(aliasSchedule);
		
		
		// Create glossary term for Broadcast		
		IGlossary glossaryBroadcast = IModelElementFactory.instance().createGlossary();
		glossaryBroadcast.setName("Broadcast");
		glossaryBroadcast.setDescription("To play a TV program online.");


		// Create label Requirement
		IGlossaryLabel labelRequirement = IModelElementFactory.instance().createGlossaryLabel();
		labelRequirement.setName("Requirement");
		labelRequirement.setColor(java.awt.Color.YELLOW.getRGB());
		
		// Create label Entity
		IGlossaryLabel labelEntity = IModelElementFactory.instance().createGlossaryLabel();
		labelEntity.setName("Requirement");
		labelEntity.setColor(java.awt.Color.GREEN.getRGB());
		
		// Create label BusinessActivity
		IGlossaryLabel labelBusinessActivity = IModelElementFactory.instance().createGlossaryLabel();
		labelBusinessActivity.setName("Requirement");
		labelBusinessActivity.setColor(java.awt.Color.ORANGE.getRGB());
		
		// Create label Behavior
		IGlossaryLabel labelBehavior = IModelElementFactory.instance().createGlossaryLabel();
		labelBehavior.setName("Behavior");
		labelBehavior.setColor(java.awt.Color.MAGENTA.getRGB());
		
		// Add label to glossary
		glossaryDiscussion.addLabel(labelRequirement);			
		glossaryArchived.addLabel(labelRequirement);
		glossaryPremiumMember.addLabel(labelEntity);
		glossaryGeneralMember.addLabel(labelEntity);
		glossaryRegister.addLabel(labelBusinessActivity);
		glossaryRegister.addLabel(labelRequirement);
		glossaryLive.addLabel(labelEntity);
		glossaryNewsletter.addLabel(labelRequirement);
		glossaryBroadcast.addLabel(labelBehavior);
		glossaryBroadcast.addLabel(labelBusinessActivity);
		
		
		// Obtain DiagramManager form ApplicationManager
		DiagramManager diagramManager = ApplicationManager.instance().getDiagramManager();
		// Create a new Grid Diagram
		IGridDiagramUIModel glossaryGrid = (IGridDiagramUIModel) diagramManager.createDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_GRID_DIAGRAM);

		// Specify the Grid Diagram for showing glossary term
		glossaryGrid.setModelTypes(new String[] {IModelElementFactory.MODEL_TYPE_GLOSSARY});		
		
		IGridDiagramColumnContainer colContainer = null;
		IModelElement[] containers = ApplicationManager.instance().getProjectManager().getProject().toAllLevelModelElementArray(IModelElementFactory.MODEL_TYPE_GRID_DIAGRAM_COLUMN_CONTAINER);
		if (containers != null && containers.length > 0) {
		  colContainer = (IGridDiagramColumnContainer) containers[0];
		} else {
		  colContainer = IModelElementFactory.instance().createGridDiagramColumnContainer();
		}
		
		// Create column from IGridDiagramColumnContainer
		// Specify the column to present name property in grid
		IGridDiagramColumn colName = colContainer.createGridDiagramColumn();
		colName.setColumnValue(IGridDiagramColumn.PROP_NAME);	
		colName.setColumnWidth(135);
		
		// Specify the 2nd column to present alias property
		IGridDiagramColumn colAlias = colContainer.createGridDiagramColumn();
		colAlias.setColumnType(IGridDiagramColumn.COLUMN_TYPE_PROPERTY);
		colAlias.setColumnValue(IGlossary.PROP_ALIASES);
		colAlias.setColumnWidth(175);
		
		// Specify the 3rd column to present alias property		
		IGridDiagramColumn colLabel = colContainer.createGridDiagramColumn();
		colLabel.setColumnType(IGridDiagramColumn.COLUMN_TYPE_PROPERTY);
		colLabel.setColumnValue(IGlossary.PROP_LABELS);
		colLabel.setColumnWidth(110);
		
		// Specify the 4th column to present alias property		
		IGridDiagramColumn colDesc = colContainer.createGridDiagramColumn();
		colDesc.setColumnType(IGridDiagramColumn.COLUMN_TYPE_PROPERTY);
		colDesc.setColumnValue(IGlossary.PROP_DOCUMENTATION);
		colDesc.setColumnWidth(400);
		
		// Set glossary to grid and show it up
		glossaryGrid.setColumns(colContainer.toGridDiagramColumnArray());
		diagramManager.openDiagram(glossaryGrid);
	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}
